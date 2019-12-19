package com.citic.demo.mapper;

import com.citic.demo.entity.OrderInfo;
import com.citic.demo.entity.PriceHistory;
import com.citic.demo.entity.SaleWay;
import com.citic.demo.entity.Tickets;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.response.OrderResponse;

import java.util.List;

public interface OrderInfoMapper {


    /**
     * 获取订单列表
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    List<OrderResponse> queryOrderList(OrderInfoQuery orderInfoQuery) throws Exception;

    /**
     * 获取订单数量
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    Integer queryOrderCount(OrderInfoQuery orderInfoQuery) throws Exception;

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
    List<SaleWay> querySaleWays(SaleWay saleWay) throws Exception;


    /**
     *
     * 获取用户所有优惠券
     *
     * @return
     * @throws Exception
     */
    List<Tickets> queryTickets(String id) throws Exception;

    /**
     *
     * 修改用户所有优惠券
     *
     * @return
     * @throws Exception
     */
    Integer updateTickets(List<Tickets> tickets) throws Exception;

    /**
     *
     * 保存优惠信息
     *
     * @return
     * @throws Exception
     */
    PriceHistory saveSalaryHistory(PriceHistory priceHistory) throws Exception;

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
     * @param orderId
     * @return
     * @throws Exception
     */
    Integer deleteOrder(Integer orderId) throws Exception;

    /**
     *
     * 获取优惠信息
     *
     * @param priceHistory
     * @return
     */
    SaleWay querySaleWay(PriceHistory priceHistory);
}