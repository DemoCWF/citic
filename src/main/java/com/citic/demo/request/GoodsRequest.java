package com.citic.demo.request;

public class GoodsRequest {
    private Integer goodsId;

    private String goodsName;

    private String des;

    private String goodsPhoto;

    private String goodsCate;

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
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto == null ? null : goodsPhoto.trim();
    }

    public String getGoodsCate() {
        return goodsCate;
    }

    public void setGoodsCate(String goodsCate) {
        this.goodsCate = goodsCate == null ? null : goodsCate.trim();
    }
}
