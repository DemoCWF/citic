package com.citic.demo.entity;

import java.math.BigDecimal;

public class SaleWay {
    private Integer salewayId;

    private Integer salewayType;

    private Integer subType;

    private String salewayDes;

    private BigDecimal salewayScale;

    private String judgePrice;

    private Integer salewayUse;

    public Integer getSalewayId() {
        return salewayId;
    }

    public void setSalewayId(Integer salewayId) {
        this.salewayId = salewayId;
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

    public String getJudgePrice() {
        return judgePrice;
    }

    public void setJudgePrice(String judgePrice) {
        this.judgePrice = judgePrice;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }
}