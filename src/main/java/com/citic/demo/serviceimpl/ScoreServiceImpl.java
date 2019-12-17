package com.citic.demo.serviceimpl;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.base.BaseConverter;
import com.citic.demo.entity.Score;
import com.citic.demo.entity.Tickets;
import com.citic.demo.mapper.ScoreMapper;
import com.citic.demo.mapper.TicketsMapper;
import com.citic.demo.request.ScoreRequest;
import com.citic.demo.request.TicketRequest;
import com.citic.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private BaseConverter<ScoreRequest, Score> requestConverter;
    /**
     * 新增积分
     *
     * @param scoreRequest
     * @return
     * @throws Exception
     */
    @Override
    public int saveScore(ScoreRequest scoreRequest) throws Exception {
        return this.scoreMapper.insert(this.requestConverter.convert(scoreRequest, Score.class));
    }

    /**
     * 通过积分id删除积分
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteScore(Integer id) throws Exception {
        return this.scoreMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新积分
     *
     * @param scoreRequest
     * @return
     * @throws Exception
     */
    @Override
    public int updateScore(ScoreRequest scoreRequest) throws Exception {
        return this.scoreMapper.updateByPrimaryKey(this.requestConverter.convert(scoreRequest,Score.class));
    }

    /**
     * 通过积分id查询积分
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Score getScoreByScoreId(Integer id) throws Exception {
        return this.scoreMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过用户id查询积分
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Score getScoreByUserId(Integer id) throws Exception {
        return this.scoreMapper.selectByUserId(id);
    }
}
