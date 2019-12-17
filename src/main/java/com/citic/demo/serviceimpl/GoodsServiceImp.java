package com.citic.demo.serviceimpl;

import com.citic.demo.base.BaseConverter;
import com.citic.demo.base.PageResult;
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

    @Override
    public PageResult<GoodsInfo> queryPageGoods(GoodsQuery goodsQuery) throws Exception {
        return new PageResult<>(goodsQuery.getPageSize(), this.queryGoodsCount(goodsQuery),
                goodsQuery.getCurrentPage(), this.queryGoods(goodsQuery));
    }

    public int queryGoodsCount(GoodsQuery goodsQuery) throws Exception {
        return goodsInfoMapper.queryGoodsCount(goodsQuery);
    }

    public List<GoodsInfo> queryGoods(GoodsQuery goodsQuery) throws Exception {
        return goodsInfoMapper.queryGoods(goodsQuery);
    }

    /**
     * 获取商品详细信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public GoodsInfo queryGoodsInfoById(Integer goodsId) throws Exception {
        return goodsInfoMapper.queryGoodsInfoById(goodsId);
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
     * @param goodsId
     * @return
     * @throws Exception
     */
    @Override
    public int deleteGoodsInfo(Integer goodsId) throws Exception {
        return goodsInfoMapper.deleteById(goodsId);
    }
}
