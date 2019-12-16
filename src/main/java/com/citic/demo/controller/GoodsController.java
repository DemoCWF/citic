package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.request.GoodsRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Resource
    private GoodsInfo goodsInfo;

    @PostMapping(value = "/query")
    public ActionResponse importService(GoodsQuery goodsQuery) throws Exception {
        List<GoodsInfo> goodsInfoList = null;
        return ActionResponse.success();
    }
}
