package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.RespBasicCode;
import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     *
     * 查询所有商品(可模糊查询)
     *
     * @param goodsQuery
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/query/all")
    @ResponseBody
    public ActionResponse queryGoods(@RequestBody GoodsQuery goodsQuery){
        try {
            return ActionResponse.success(goodsService.queryPageGoods(goodsQuery));
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
    }


    /**
     *
     * 查询单件商品详细信息
     *
     * @param goodsQuery
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/query/id")
    @ResponseBody
    public ActionResponse queryGoodsInfo(@RequestBody GoodsQuery goodsQuery){
        if (goodsQuery.getGoodsId() == null){
            ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "商品ID不能为空!");
        }
        GoodsInfo goodsInfo = null;
        try {
            goodsInfo = goodsService.queryGoodsInfoById(goodsQuery.getGoodsId());
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success(goodsInfo);
    }

    /**
     *
     * 保存商品
     *
     * @param goodsRequest
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public ActionResponse saveGoodsInfo(@RequestBody GoodsRequest goodsRequest){
        try {
            goodsService.saveGoodsInfo(goodsRequest);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }


    /**
     *
     * 商品信息修正
     *
     * @param goodsRequest
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public ActionResponse updateGoodsInfo(@RequestBody GoodsRequest goodsRequest){
        if (goodsRequest.getGoodsId() == null){
            ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "商品ID不能为空!");
        }
        try {
            goodsService.updateGoodsInfo(goodsRequest);
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }


    /**
     *
     * 商品删除
     *
     * @param goodsQuery
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    public ActionResponse deleteGoodsInfo(@RequestBody GoodsQuery goodsQuery){
        if (goodsQuery.getGoodsId() == null){
            ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "商品ID不能为空!");
        }
        try {
            goodsService.deleteGoodsInfo(goodsQuery.getGoodsId());
        } catch (Exception e) {
            return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION);
        }
        return ActionResponse.success();
    }
}
