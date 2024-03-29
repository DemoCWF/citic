package com.citic.demo.query;

import com.citic.demo.base.ObjectQuery;

public class OrderInfoQuery extends ObjectQuery {

    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private String goodsName;

    private Long orderTime;

    private Integer goodsNum;

    private String orderState;

    private String pay;

    private String realPay;

    private Long payTime;

    private String salePrice;

    private String saleway;

    private String userAccount;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = Integer.parseInt(userId);
    }

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

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay == null ? null : pay.trim();
    }

    public String getRealPay() {
        return realPay;
    }

    public void setRealPay(String realPay) {
        this.realPay = realPay == null ? null : realPay.trim();
    }

    public String getSaleway() {
        return saleway;
    }

    public void setSaleway(String saleway) {
        this.saleway = saleway == null ? null : saleway.trim();
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}