package com.citic.demo.service;

import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.request.GoodsRequest;

import java.util.List;

public interface GoodsService {

    /**
     *
     * 获取商品信息
     *
     * @param goodsQuery
     * @return
     * @throws Exception
     */
    List<GoodsInfo> query(GoodsQuery goodsQuery) throws Exception;

    /**
     *
     * 获取商品详细信息
     *
     * @param primaryKey
     * @return
     */
    GoodsInfo queryGoodsInfoById(String primaryKey) throws Exception;


    /**
     *
     * 新增商品
     *
     * @param goodsRequest
     * @return
     * @throws Exception
     */
    int saveGoodsInfo(GoodsRequest goodsRequest) throws Exception;


    /**
     *
     * 修改商品信息
     *
     * @param goodsRequest
     * @return
     * @throws Exception
     */
    int updateGoodsInfo(GoodsRequest goodsRequest) throws Exception;


    /**
     *
     * 删除
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    int deleteGoodsInfo(String primaryKey) throws Exception;
}
