package com.citic.demo.service;

import com.citic.demo.base.PageResult;
import com.citic.demo.entity.*;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.response.OrderResponse;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    /**
     * 获取订单列表
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    PageResult<OrderResponse> queryOrder(OrderInfoQuery orderInfoQuery) throws Exception;

    /**
     *
     * 获取订单详情
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    OrderInfo queryOrderById(Integer orderId) throws Exception;

    /**
     *
     * 保存订单
     *
     * @param orderRequest
     * @return
     * @throws Exception
     */
    Integer saveOrder(OrderRequest orderRequest) throws Exception;


    /**
     *
     * 获取所有优惠信息
     *
     * @return
     * @throws Exception
     */
    Map<String, List<SaleWay>> saleWay(UserInfo userInfo) throws Exception;


    /**
     *
     * 获取用户所有优惠券
     *
     * @return
     * @throws Exception
     */
    Map<String, List<Tickets>> tickets(Integer userId) throws Exception;

    /**
     *
     * 保存优惠信息
     *
     * @return
     * @throws Exception
     */
    Integer saveSalaryHistory(PriceHistory priceHistory) throws Exception;

    /**
     *
     * 更新优惠信息
     *
     * @return
     * @throws Exception
     */
    PriceHistory updateSalaryHistory(PriceHistory priceHistory) throws Exception;

    /**
     *
     * 修改订单
     *
     * @param orderRequest
     * @return
     * @throws Exception
     */
    Integer updateOrder(OrderRequest orderRequest) throws Exception;

    /**
     *
     * 删除订单
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    PageResult<OrderResponse> deleteOrder(OrderInfoQuery orderInfoQuery) throws Exception;
}
