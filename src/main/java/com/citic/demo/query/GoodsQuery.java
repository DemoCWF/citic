package com.citic.demo.query;

import com.citic.demo.base.ObjectQuery;

import java.util.List;

public class GoodsQuery extends ObjectQuery {

    private Integer goodsId;

    private String goodsName;

    private List<String> goodCate;

    private String mult;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getMult() {
        return mult;
    }

    public void setMult(String mult) {
        this.mult = mult;
    }

    public List<String> getGoodCate() {
        return goodCate;
    }

    public void setGoodCate(List<String> goodCate) {
        this.goodCate = goodCate;
    }
}
