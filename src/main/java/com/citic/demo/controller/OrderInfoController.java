package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.PageResult;
import com.citic.demo.base.RespBasicCode;
import com.citic.demo.entity.OrderInfo;
import com.citic.demo.query.OrderInfoQuery;
import com.citic.demo.request.OrderRequest;
import com.citic.demo.service.OrderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
            orderInfoService.queryOrder(orderInfoQuery);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success(pageResult);
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public ActionResponse queryOrderById(@PathVariable Integer id) {
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

    @PostMapping("/save")
    @ResponseBody
    public ActionResponse saveOrder(@RequestBody OrderRequest orderRequest) {
        try {
            orderInfoService.saveOrder(orderRequest);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }

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

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ActionResponse deleteOrder(@PathVariable Integer id) {
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
