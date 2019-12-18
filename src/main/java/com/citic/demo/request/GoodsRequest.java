package com.citic.demo.request;

public class GoodsRequest {
    // ID
    private Integer goodId;

    // 商品名
    private String goodName;

    // 描述
    private String goodDescription;

    // 价格
    private String goodPrice;

    // 图像
    private String goodImgSrc;

    // 类别
    private String goodCate;

    // 数量
    private String count;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodImgSrc() {
        return goodImgSrc;
    }

    public void setGoodImgSrc(String goodImgSrc) {
        this.goodImgSrc = goodImgSrc;
    }

    public String getGoodCate() {
        return goodCate;
    }

    public void setGoodCate(String goodCate) {
        this.goodCate = goodCate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
