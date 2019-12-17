package com.citic.demo.request;

import lombok.*;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreRequest {
    private Integer scoreId;

    private Integer userId;

    private Integer scoreSum;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(Integer scoreSum) {
        this.scoreSum = scoreSum;
    }
}
