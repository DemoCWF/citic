package com.citic.demo.entity;

import java.math.BigDecimal;

public class SaleWay {
    private Integer salewayId;

    private Integer userId;

    private Integer salewayType;

    private String salewayDes;

    private BigDecimal salewayScale;

    private Integer salewayUse;

    public Integer getSalewayId() {
        return salewayId;
    }

    public void setSalewayId(Integer salewayId) {
        this.salewayId = salewayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSalewayType() {
        return salewayType;
    }

    public void setSalewayType(Integer salewayType) {
        this.salewayType = salewayType;
    }

    public String getSalewayDes() {
        return salewayDes;
    }

    public void setSalewayDes(String salewayDes) {
        this.salewayDes = salewayDes == null ? null : salewayDes.trim();
    }

    public BigDecimal getSalewayScale() {
        return salewayScale;
    }

    public void setSalewayScale(BigDecimal salewayScale) {
        this.salewayScale = salewayScale;
    }

    public Integer getSalewayUse() {
        return salewayUse;
    }

    public void setSalewayUse(Integer salewayUse) {
        this.salewayUse = salewayUse;
    }
}