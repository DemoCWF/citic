package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.PageResult;
import com.citic.demo.base.RespBasicCode;
import com.citic.demo.entity.OrderInfo;
import com.citic.demo.entity.PriceHistory;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.service.OrderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DecimalFormat;

@Controller
@RequestMapping(value = "/order")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 获取订单列表
     *
     * @param orderInfoQuery
     * @return
     * @throws Exception
     */
    @PostMapping("/query/all")
    @ResponseBody
    public ActionResponse queryOrderList(@RequestBody OrderInfoQuery orderInfoQuery) {
        PageResult<OrderInfo> pageResult = null;
        try {
            pageResult = orderInfoService.queryOrder(orderInfoQuery);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success(pageResult);
    }

    /**
     * 获取订单详情
     *
     * @param id 订单ID
     * @return
     */
    @GetMapping("/query/{id}")
    @ResponseBody
    public ActionResponse queryOrderById(@PathVariable("id") Integer id) {
        if (id == null) {
            ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "订单ID不能为空!");
        }
        OrderInfo orderInfo = null;
        try {
            orderInfo = orderInfoService.queryOrderById(id);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success(orderInfo);
    }

    /**
     * 保存订单
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public ActionResponse saveOrder(@RequestBody OrderRequest orderRequest) {
        int orderId;
        try {
            orderId = orderInfoService.saveOrder(orderRequest);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success(orderId);
    }


    /**
     *
     * 获取所有优惠信息列表
     *
     * @return
     */
    @GetMapping("/saleway")
    @ResponseBody
    public ActionResponse saleWay(){
        try {
            ActionResponse.success(orderInfoService.saleWay());
        } catch (Exception e) {
            ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }

    /**
     *
     * 获取用户所有优惠
     *
     * @param id
     * @return
     */
    @GetMapping("/tickets/{id}")
    @ResponseBody
    public ActionResponse tickets(@PathVariable("id") Integer id){
        try {
            ActionResponse.success(orderInfoService.tickets(id));
        } catch (Exception e) {
            ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }

    /**
     *
     * 优惠信息保存
     *
     * @param
     * @return
     */
    @PostMapping("/salary/save")
    @ResponseBody
    public ActionResponse salaryHistorySave(@RequestBody PriceHistory priceHistory) throws Exception{

        // 校验及修改
        orderInfoService.saveSalaryHistory(priceHistory);

        return ActionResponse.success();
    }

    /**
     * 更新订单
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ActionResponse updateOrder(@RequestBody OrderRequest orderRequest) {
        if (orderRequest.getOrderId() == null) {
            ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "订单ID不能为空!");
        }
        try {
            orderInfoService.updateOrder(orderRequest);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }

    /**
     * 删除订单
     *
     * @param id 订单ID
     * @return
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ActionResponse deleteOrder(@PathVariable("id") Integer id) {
        if (id == null) {
            ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "订单ID不能为空!");
        }
        try {
            orderInfoService.deleteOrder(id);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }
}
