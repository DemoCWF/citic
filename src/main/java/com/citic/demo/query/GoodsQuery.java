package com.citic.demo.query;

import com.citic.demo.base.ObjectQuery;

import java.util.List;

public class GoodsQuery extends ObjectQuery {

    private Integer goodsId;

    private String goodsName;

    private List<String> goodsCate;

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

    public List<String> getGoodsCate() {
        return goodsCate;
    }

    public void setGoodsCate(List<String> goodsCate) {
        this.goodsCate = goodsCate;
    }

    public String getMult() {
        return mult;
    }

    public void setMult(String mult) {
        this.mult = mult;
    }
}
