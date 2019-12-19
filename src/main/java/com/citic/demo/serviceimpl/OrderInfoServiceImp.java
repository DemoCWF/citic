package com.citic.demo.serviceimpl;

import com.citic.demo.base.BaseConverter;
import com.citic.demo.base.PageResult;
import com.citic.demo.entity.*;
import com.citic.demo.mapper.GoodsInfoMapper;
import com.citic.demo.mapper.OrderInfoMapper;
import com.citic.demo.mapper.ScoreMapper;
import com.citic.demo.mapper.TicketsMapper;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.response.OrderResponse;
import com.citic.demo.service.OrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.Ticket;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderInfoServiceImp implements OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    @Resource
    private ScoreMapper scoreMapper;

    @Resource
    private TicketsMapper ticketsMapper;

    @Resource
    private BaseConverter<OrderInfo, OrderResponse> reponseConverter;

    /**
     * 获取订单列表
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    @Override
    public PageResult<OrderResponse> queryOrder(OrderInfoQuery orderInfoQuery) throws Exception {
        return new PageResult<>(orderInfoQuery.getPageSize(), this.queryOrderCount(orderInfoQuery),
                orderInfoQuery.getCurrentPage(), this.queryOrderList(orderInfoQuery));
    }

    private List<OrderResponse> queryOrderList(OrderInfoQuery orderInfoQuery) throws Exception {
        return orderInfoMapper.queryOrderList(orderInfoQuery);
    }

    private Integer queryOrderCount(OrderInfoQuery orderInfoQuery) throws Exception {
        return orderInfoMapper.queryOrderCount(orderInfoQuery);
    }

    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @Override
    public OrderInfo queryOrderById(Integer orderId) throws Exception {
        OrderInfo orderInfo = orderInfoMapper.queryOrderById(orderId);
        GoodsInfo goodsInfo = goodsInfoMapper.queryGoodsInfoById(orderInfo.getGoodId());
        List<SaleWay> saleWay = null;
        if ("".equals(orderInfo.getSaleway()) || orderInfo.getSaleway() != null) {
            List<String> saleWayList = Arrays.asList(orderInfo.getSaleway().split(","));
            /**
             *
             * 优惠金额计算
             *
             * 1. 满减/随机减
             * 2. 优惠券
             * 3. 积分
             *
             */

        }

        return orderInfo;
    }

    /**
     * 保存订单
     *
     * @param orderRequest
     * @return
     * @throws Exception
     */
    @Override
    public Integer saveOrder(OrderRequest orderRequest) throws Exception {
        Long currentTime = System.currentTimeMillis();
        orderRequest.setOrderTime(currentTime);
        orderRequest.setOrderStatus("未完成");

        //

        orderInfoMapper.saveOrder(orderRequest);
        return orderRequest.getOrderId();
    }

    /**
     * 获取所有优惠信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, List<SaleWay>> saleWay(UserInfo userInfo) throws Exception {
        /**
        //获取所有优惠信息
        List<SaleWay> saleWayList = orderInfoMapper.querySaleWays();
        Map<String, List<SaleWay>> saleWayMap = new HashMap<>();
        for (SaleWay saleWay : saleWayList) {
            String salewayType = saleWay.getSalewayType().toString();
            if (saleWayMap.containsKey(salewayType)) {
                saleWayMap.get(salewayType).add(saleWay);
            } else {
                List<SaleWay> list = new ArrayList<>();
                list.add(saleWay);
                saleWayMap.put(salewayType, list);
            }
        }
         */

        Map<String, List<SaleWay>> saleWayMap = new HashMap<>();

        // 1.获取满减信息
        SaleWay saleWay = new SaleWay();
        saleWay.setSalewayType(1);
        saleWay.setSalewayUse(1);
        List<SaleWay> reductions = orderInfoMapper.querySaleWays(saleWay);


        // 2.用户所有优惠券及数量
        List<Tickets> coupons = ticketsMapper.selectByUserId(userInfo.getUserId());



        // 3.获取用户积分
        Integer integral = scoreMapper.selectByUserId(userInfo.getUserId()).getScoreSum();

        return saleWayMap;
    }

    /**
     * 获取用户所有优惠券
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, List<Tickets>> tickets(Integer userId) throws Exception {
        List<Tickets> ticketsList = orderInfoMapper.queryTickets(userId.toString());
        Map<String, List<Tickets>> ticketsMap = new HashMap<>();
        for (Tickets ticket : ticketsList) {
            String ticketType = ticket.getTicketsType();
            if (ticketsMap.containsKey(ticketType)) {
                ticketsMap.get(ticketType).add(ticket);
            } else {
                List<Tickets> list = new ArrayList<>();
                list.add(ticket);
                ticketsMap.put(ticketType, list);
            }
        }
        return ticketsMap;
    }

    /**
     * 保存优惠信息
     *
     * @param priceHistory
     * @return
     * @throws Exception
     */
    @Override
    public Integer saveSalaryHistory(PriceHistory priceHistory) throws Exception {

        // 校验
//        List<SaleWay> saleWayList = orderInfoMapper.querySaleWays();

        OrderRequest orderInfo = new OrderRequest();
        orderInfo.setUserId(priceHistory.getUserId());
        orderInfo.setGoodId(priceHistory.getGoodsId());
        Long time = System.currentTimeMillis();
        orderInfo.setOrderTime(time);
        orderInfo.setPayTime(time);
        orderInfo.setGoodNum(priceHistory.getGoodsNum());
        orderInfo.setPay(priceHistory.getCountPri());
        orderInfo.setSaleway(priceHistory.getPayClass().toString());

        if (priceHistory.getPayClass() == 0) {
            // 随机减计算
            double a = Math.random() * 2;
            DecimalFormat df = new DecimalFormat("0.00");
            String rand = df.format(a);

            BigDecimal count = new BigDecimal(priceHistory.getAfterPri());
            BigDecimal random = new BigDecimal(rand);
            String relPri = count.multiply(random).toString();

            relPri = df.format(Double.parseDouble(relPri) / 100);
            Double pay = Double.parseDouble(priceHistory.getAfterPri()) - Double.parseDouble(relPri);

            orderInfo.setRealPay(pay.toString());
            // 用户相关信息修改--修改券的数量
//            List<Tickets> ticketsList = orderInfoMapper.queryTickets(priceHistory.getUserId().toString());
//            List<String> salaryId = priceHistory.getSalaryId();
//            for (Tickets tickets : ticketsList) {
//                if (salaryId.contains(tickets.getSalaryId())){
//                    tickets.setTicketsNum(tickets.getTicketsNum() - 1);
//                }
//            }
//            orderInfoMapper.updateTickets(ticketsList);

            int ticketCount = orderInfoMapper.queryTicketCount(priceHistory);
            if (ticketCount <= 0){
                throw new Exception("抵扣券数量错误!");
            }
            Tickets ticket = new Tickets();
            ticket.setUserId(priceHistory.getUserId());
            ticket.setTicketsType(priceHistory.getSalaryId().toString());
            ticket.setTicketsNum(ticketCount - 1);
            orderInfoMapper.updateTickets(ticket);

            // 商品数量修改
            GoodsInfo goodsInfo = goodsInfoMapper.queryGoodsInfoById(priceHistory.getGoodsId());
            Integer num = Integer.parseInt(goodsInfo.getCount()) - priceHistory.getGoodsNum();
            goodsInfo.setCount(num.toString());
            goodsInfoMapper.update(goodsInfo);

            // 用户积分修改
            Score score = scoreMapper.selectByUserId(priceHistory.getUserId());
            if (score.getScoreSum() < Integer.parseInt(priceHistory.getScores())){
                throw new Exception("积分错误!");
            }

            score.setScoreSum(score.getScoreSum() - Integer.parseInt(priceHistory.getScores()));
            scoreMapper.updateByPrimaryKeySelective(score);
        }

        orderInfo.setOrderStatus("已完成");
        return orderInfoMapper.saveOrder(orderInfo);
    }

    /**
     * 更新优惠信息
     *
     * @param priceHistory
     * @return
     * @throws Exception
     */
    @Override
    public PriceHistory updateSalaryHistory(PriceHistory priceHistory) throws Exception {
        orderInfoMapper.updateSalaryHistory(priceHistory);
        return null;
    }

    /**
     * 修改订单
     *
     * @param orderRequest
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateOrder(OrderRequest orderRequest) throws Exception {
        return orderInfoMapper.updateOrder(orderRequest);
    }

    /**
     * 删除订单
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    @Override
    public PageResult<OrderResponse> deleteOrder(OrderInfoQuery orderInfoQuery) throws Exception {
        orderInfoMapper.deleteOrder(orderInfoQuery.getOrderId());
        return this.queryOrder(orderInfoQuery);
    }
}
