package com.citic.demo.response;

import com.citic.demo.entity.GoodsInfo;
import com.citic.demo.entity.SaleWay;

import java.util.Date;

public class OrderResponse {

    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private String goodsName;

    private Date orderTime;

    private Integer goodsNum;

    private String orderState;

    private String pay;

    private String realPay;

    private Date payTime;

    private String saleway;

    private GoodsInfo goodsInfo;

    private SaleWay saleWay;

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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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
        this.orderState = orderState;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getRealPay() {
        return realPay;
    }

    public void setRealPay(String realPay) {
        this.realPay = realPay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getSaleway() {
        return saleway;
    }

    public void setSaleway(String saleway) {
        this.saleway = saleway;
    }

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public SaleWay getSaleWay() {
        return saleWay;
    }

    public void setSaleWay(SaleWay saleWay) {
        this.saleWay = saleWay;
    }
}
