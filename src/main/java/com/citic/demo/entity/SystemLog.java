package com.citic.demo.entity;

import java.util.Date;

public class SystemLog {
    private Integer logId;

    private Integer userId;

    private Date opTime;

    private String opWay;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getOpWay() {
        return opWay;
    }

    public void setOpWay(String opWay) {
        this.opWay = opWay == null ? null : opWay.trim();
    }
}