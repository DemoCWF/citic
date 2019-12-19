package com.citic.demo.response;

import com.citic.demo.entity.SaleWay;

import java.util.List;

public class SaleWayResponse {
    private List<SaleWay> saleWayList;

    private List<TicketResponse> coupons;

    private String integral;

    public List<SaleWay> getSaleWayList(List<SaleWay> saleWayList) {
        return this.saleWayList;
    }

    public void setSaleWayList(List<SaleWay> saleWayList) {
        this.saleWayList = saleWayList;
    }

    public List<TicketResponse> getCoupons(List<TicketResponse> coupons) {
        return this.coupons;
    }

    public void setCoupons(List<TicketResponse> coupons) {
        this.coupons = coupons;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }
}
