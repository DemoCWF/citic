package com.citic.demo.serviceimpl;

import com.citic.demo.base.BaseConverter;
import com.citic.demo.base.PageResult;
import com.citic.demo.entity.*;
import com.citic.demo.mapper.GoodsInfoMapper;
import com.citic.demo.mapper.OrderInfoMapper;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.response.OrderResponse;
import com.citic.demo.service.OrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class OrderInfoServiceImp implements OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

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
    public PageResult<OrderInfo> queryOrder(OrderInfoQuery orderInfoQuery) throws Exception {
        return new PageResult<>(orderInfoQuery.getPageSize(), this.queryOrderCount(orderInfoQuery),
                orderInfoQuery.getCurrentPage(), this.queryOrderList(orderInfoQuery));
    }

    private List<OrderInfo> queryOrderList(OrderInfoQuery orderInfoQuery) throws Exception {
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
        GoodsInfo goodsInfo = goodsInfoMapper.queryGoodsInfoById(orderInfo.getGoodsId());
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

        return null;
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
    public Map<String, List<SaleWay>> saleWay() throws Exception {
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
        orderInfo.setGoodsId(priceHistory.getGoodsId());
        Long time = System.currentTimeMillis();
        orderInfo.setOrderTime(time);
        orderInfo.setPayTime(time);
        orderInfo.setGoodsNum(priceHistory.getGoodsNum());
        orderInfo.setPay(priceHistory.getCountPri());
        orderInfo.setRealPay(priceHistory.getCountPri());
        orderInfo.setSaleway(priceHistory.getPayClass().toString());

        if (priceHistory.getPayClass() == 0) {
            // 随机减计算
            double a = Math.random() * 2;
            DecimalFormat df = new DecimalFormat("0.00");
            String rand = df.format(a);

            BigDecimal count = new BigDecimal(priceHistory.getSalePri());
            BigDecimal random = new BigDecimal(rand);
            String relPri = count.multiply(random).toString();

            orderInfo.setRealPay(relPri);
            // 用户相关信息修改
            List<Tickets> ticketsList = orderInfoMapper.queryTickets(priceHistory.getUserId().toString());
            List<String> salaryId = priceHistory.getSalaryId();
            for (Tickets tickets : ticketsList) {
                if (salaryId.contains(tickets.getSalaryId())){
                    tickets.setTicketsNum(tickets.getTicketsNum() - 1);
                }
            }
            orderInfoMapper.updateTickets(ticketsList);
            // 商品数量修改
            GoodsInfo goodsInfo = goodsInfoMapper.queryGoodsInfoById(priceHistory.getGoodsId());
            Integer num = Integer.parseInt(goodsInfo.getCount()) - priceHistory.getGoodsNum();
            goodsInfo.setCount(num.toString());
            goodsInfoMapper.update(goodsInfo);

            // 用户积分修改
        }

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
     * @param orderId
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteOrder(Integer orderId) throws Exception {
        return orderInfoMapper.deleteOrder(orderId);
    }
}
