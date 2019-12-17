package com.citic.demo.service;

import com.citic.demo.entity.Tickets;
import com.citic.demo.request.TicketRequest;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
public interface TicketsService {

    Tickets getTicketById(Integer id) throws Exception;;

    int updateTicket(TicketRequest ticketRequest) throws Exception;;

    int deleteTicketById(Integer id) throws Exception;;

    int saveTickets(TicketRequest ticketRequest) throws Exception;;
}
