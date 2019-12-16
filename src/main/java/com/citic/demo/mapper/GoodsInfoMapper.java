package com.citic.demo.mapper;

import com.citic.demo.base.IBaseDao;
import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.request.GoodsRequest;

import java.util.List;

public interface GoodsInfoMapper extends IBaseDao<GoodsInfo> {

    List<GoodsInfo> query(GoodsQuery goodsQuery) throws Exception;

    GoodsInfo queryGoodsInfoById(String primaryKey) throws Exception;

    int saveGoodsInfo(GoodsRequest goodsRequest) throws Exception;

    int updateGoodsInfo(GoodsRequest goodsRequest) throws Exception;

    int deleteGoodsInfo(String primaryKey) throws Exception;

}