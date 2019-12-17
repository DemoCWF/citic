package com.citic.demo.service;

import com.citic.demo.entity.Score;
import com.citic.demo.request.ScoreRequest;
import com.citic.demo.request.TicketRequest;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
public interface ScoreService {
    /**保存积分
     * @param ticketRequest
     * @return
     * @throws Exception
     */
    int saveScore(ScoreRequest scoreRequest) throws Exception;

    /**通过积分id删除积分
     * @param ticketRequest
     * @return
     * @throws Exception
     */
    int deleteScore(Integer id) throws Exception;

    /**更新积分
     * @param ticketRequest
     * @return
     * @throws Exception
     */
    int updateScore(ScoreRequest scoreRequest) throws Exception;

    /**通过积分id查询积分
     * @param id
     * @return
     * @throws Exception
     */
    Score getScoreByScoreId(Integer id) throws Exception;

    /**通过用户id查询积分
     * @param id
     * @return
     * @throws Exception
     */
    Score getScoreByUserId(Integer id) throws Exception;
}
