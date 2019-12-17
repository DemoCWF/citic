package com.citic.demo.controller;

import com.citic.demo.base.ActionResponse;
import com.citic.demo.request.TicketRequest;
import com.citic.demo.request.UserRequest;
import com.citic.demo.service.TicketsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
@Slf4j
@Controller
@RequestMapping(value = "/ticket")
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;

    /**新增优惠券
     * @param ticketRequest
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/save")
    public ActionResponse saveTicket(@RequestBody TicketRequest ticketRequest) throws Exception {
        ticketRequest = new TicketRequest();
        ticketRequest.setUserId(1);
        ticketRequest.setTicketsNum(2333);
        ticketRequest.setTicketsType("A");
        return ActionResponse.success(this.ticketsService.saveTickets(ticketRequest));
    }


    /**删除优惠券
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public ActionResponse deleteTicket(@PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(this.ticketsService.deleteTicketById(id));
    }

    /**修改优惠券
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ActionResponse updateTicket(@RequestBody TicketRequest ticketRequest) throws Exception {
        return ActionResponse.success(this.ticketsService.updateTicket(ticketRequest));
    }

    /**通过优惠卷id查找优惠券
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getById/{id}")
    public ActionResponse getTicketById(@PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(this.ticketsService.getTicketById(id));
    }

    /**通过用户id查找优惠券
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getByUserId/{id}")
    public ActionResponse getTicketByUserId(@PathVariable("id") Integer id) throws Exception {
        return ActionResponse.success(this.ticketsService.getTicketsByUserId(id));
    }




}
