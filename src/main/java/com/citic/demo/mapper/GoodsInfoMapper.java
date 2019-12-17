package com.citic.demo.mapper;

import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.query.GoodsQuery;

import java.util.List;

public interface GoodsInfoMapper {

    List<GoodsInfo> query(GoodsQuery goodsQuery) throws Exception;

    GoodsInfo queryGoodsInfoById(Integer goodsId) throws Exception;

    int insert(GoodsInfo goodsInfo) throws Exception;

    int update(GoodsInfo goodsInfo) throws Exception;

    int deleteById(Integer goodsId) throws Exception;

    int queryGoodsCount(GoodsQuery goodsQuery);

    List<GoodsInfo> queryGoods(GoodsQuery goodsQuery);
}