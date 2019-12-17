package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.request.ScoreRequest;
import com.citic.demo.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
@Slf4j
@RequestMapping(value = "/score")
@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**新增积分
     * @param scoreRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/save")
    public ActionResponse saveScore(@RequestBody ScoreRequest scoreRequest) throws Exception {
        return ActionResponse.success(this.scoreService.saveScore(scoreRequest));

    }

    /**通过积分id删除积分
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public ActionResponse deleteScore(@PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(this.scoreService.deleteScore(id));
    }

    /**更新积分
     * @param scoreRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ActionResponse updateScore(@RequestBody ScoreRequest scoreRequest) throws Exception {
        return ActionResponse.success(this.scoreService.updateScore(scoreRequest));
    }

    /**通过积分id查询积分
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getByScoreId/{id}")
    public ActionResponse getScoreByScoreId(@PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(this.scoreService.getScoreByScoreId(id));
    }

    /**通过用户id查询积分
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getByUserId/{id}")
    public ActionResponse getScoreByUserId(@PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(this.scoreService.getScoreByUserId(id));
    }
}
