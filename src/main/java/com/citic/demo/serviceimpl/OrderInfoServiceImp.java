package com.citic.demo.serviceimpl;

import com.citic.demo.base.BaseConverter;
import com.citic.demo.base.PageResult;
import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.entity.OrderInfo;
import com.citic.demo.entity.SaleWay;
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
import java.util.Arrays;
import java.util.List;

@Service
public class OrderInfoServiceImp implements OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    @Resource
    private BaseConverter<OrderResponse, OrderInfo> reponseConverter;

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

    private List<OrderInfo> queryOrderList(OrderInfoQuery orderInfoQuery) throws Exception{
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
        if ("".equals(orderInfo.getSaleway()) || orderInfo.getSaleway() != null){
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
        return orderInfoMapper.saveOrder(orderRequest);
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
