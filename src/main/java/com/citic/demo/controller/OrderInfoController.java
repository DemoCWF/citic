package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.PageResult;
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
    public ActionResponse queryOrderList(@RequestBody OrderInfoQuery orderInfoQuery) throws Exception {
        PageResult<OrderInfo> pageResult = orderInfoService.queryOrder(orderInfoQuery);
        return ActionResponse.success();
    }

    @GetMapping("/query/{id}")
    @ResponseBody
    public ActionResponse queryOrderById(@PathVariable Integer id) throws Exception {
        OrderInfo orderInfo = orderInfoService.queryOrderById(id);
        return ActionResponse.success(orderInfo);
    }

    @PostMapping("/save")
    @ResponseBody
    public ActionResponse saveOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        return ActionResponse.success(orderInfoService.saveOrder(orderRequest));
    }

    @PostMapping("/update")
    @ResponseBody
    public ActionResponse updateOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        return ActionResponse.success(orderInfoService.updateOrder(orderRequest));
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public ActionResponse deleteOrder(@PathVariable Integer id) {
        return ActionResponse.success(id);
    }
}
