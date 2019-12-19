package com.citic.demo.response;

public class TicketResponse {
    private Integer ticketsId;

    private Integer userId;

    private Integer ticketsType;

    private String descripition;

    private String price;

    private Integer ticketsNum;

    public Integer getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(Integer ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTicketsNum() {
        return ticketsNum;
    }

    public void setTicketsNum(Integer ticketsNum) {
        this.ticketsNum = ticketsNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    public Integer getTicketsType() {
        return ticketsType;
    }

    public void setTicketsType(Integer ticketsType) {
        this.ticketsType = ticketsType;
    }
}