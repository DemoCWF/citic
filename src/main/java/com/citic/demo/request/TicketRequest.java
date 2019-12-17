package com.citic.demo.request;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
public class TicketRequest {
    private Integer ticketsId;

    private Integer userId;

    private String ticketsType;

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
}
