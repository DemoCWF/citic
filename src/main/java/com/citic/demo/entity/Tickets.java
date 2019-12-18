package com.citic.demo.entity;

public class Tickets {
    private Integer ticketsId;

    private Integer userId;

    private Integer salaryId;

    private String ticketsType;

    private String subType;

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

    public String getTicketsType() {
        return ticketsType;
    }

    public void setTicketsType(String ticketsType) {
        this.ticketsType = ticketsType == null ? null : ticketsType.trim();
    }

    public Integer getTicketsNum() {
        return ticketsNum;
    }

    public void setTicketsNum(Integer ticketsNum) {
        this.ticketsNum = ticketsNum;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }
}