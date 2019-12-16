package com.citic.demo.serviceimpl;

import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.service.GoodsService;

import java.util.List;

public class GoodsServiceImp implements GoodsService {
    
    /**
     * 获取商品信息
     *
     * @param goodsQuery
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsInfo> query(GoodsQuery goodsQuery) throws Exception {
        return null;
    }

    /**
     * 获取商品详细信息
     *
     * @param primaryKey
     * @return
     */
    @Override
    public GoodsInfo queryGoodsInfoById(String primaryKey) throws Exception {
        return null;
    }

    /**
     * 新增商品
     *
     * @param goodsRequest
     * @return
     * @throws Exception
     */
    @Override
    public int saveGoodsInfo(GoodsRequest goodsRequest) throws Exception {
        return 0;
    }

    /**
     * 修改商品信息
     *
     * @param goodsRequest
     * @return
     * @throws Exception
     */
    @Override
    public int updateGoodsInfo(GoodsRequest goodsRequest) throws Exception {
        return 0;
    }

    /**
     * 删除
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    @Override
    public int deleteGoodsInfo(String primaryKey) throws Exception {
        return 0;
    }
}
