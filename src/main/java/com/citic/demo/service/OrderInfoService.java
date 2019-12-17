package com.citic.demo.service;

import com.citic.demo.base.PageResult;
import com.citic.demo.entity.OrderInfo;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.response.OrderResponse;

public interface OrderInfoService {

    /**
     * 获取订单列表
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    PageResult<OrderInfo> queryOrder(OrderInfoQuery orderInfoQuery) throws Exception;

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
     * @param orderId
     * @return
     * @throws Exception
     */
    Integer deleteOrder(Integer orderId) throws Exception;
}
