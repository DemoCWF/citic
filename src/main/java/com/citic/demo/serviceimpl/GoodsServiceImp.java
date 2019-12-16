package com.citic.demo.serviceimpl;

import com.citic.demo.base.BaseConverter;
import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.mapper.GoodsInfoMapper;
import com.citic.demo.query.GoodsQuery;
import com.citic.demo.request.GoodsRequest;
import com.citic.demo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;
    @Resource
    private BaseConverter<GoodsRequest, GoodsInfo> requestConverter;

    /**
     * 获取商品信息
     *
     * @param goodsQuery
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsInfo> query(GoodsQuery goodsQuery) throws Exception {
        return goodsInfoMapper.query(goodsQuery);
    }

    /**
     * 获取商品详细信息
     *
     * @param primaryKey
     * @return
     */
    @Override
    public GoodsInfo queryGoodsInfoById(String primaryKey) throws Exception {
        return goodsInfoMapper.queryGoodsInfoById(primaryKey);
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
        GoodsInfo goodsInfo = requestConverter.convert(goodsRequest, GoodsInfo.class);
        return goodsInfoMapper.insert(goodsInfo);
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
        GoodsInfo goodsInfo = requestConverter.convert(goodsRequest, GoodsInfo.class);
        return goodsInfoMapper.update(goodsInfo);
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
        return goodsInfoMapper.deleteById(primaryKey);
    }
}
