package com.citic.demo.entity;

import java.util.List;

public class PriceHistory {

    // 订单ID
    private Integer orderId;

    // 商品ID
    private Integer goodsId;

    private Integer goodsNum;

    // 用户ID
    private Integer userId;

    // 支付方式
    private Integer payClass;

    // 优惠ID
    private List<String> salaryId;

    // 原始价格
    private String countPri;

    // 使用积分数量
    private String scores;

    // 优惠价格
    private String salePri;

    // 优惠后价格
    private String afterPri;

    // 是否删除
    private Integer status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCountPri() {
        return countPri;
    }

    public void setCountPri(String countPri) {
        this.countPri = countPri;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getSalePri() {
        return salePri;
    }

    public void setSalePri(String salePri) {
        this.salePri = salePri;
    }

    public String getAfterPri() {
        return afterPri;
    }

    public void setAfterPri(String afterPri) {
        this.afterPri = afterPri;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(List<String> salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getPayClass() {
        return payClass;
    }

    public void setPayClass(Integer payClass) {
        this.payClass = payClass;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
