package com.citic.demo.serviceimpl;

import com.citic.demo.base.BaseConverter;
import com.citic.demo.entity.Tickets;
import com.citic.demo.mapper.TicketsMapper;
import com.citic.demo.request.TicketRequest;
import com.citic.demo.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 * Create time  2019/12/17
 * Author：Democwf
 */
@Service
public class TicketsServiceImpl implements TicketsService {
    @Autowired
    private TicketsMapper ticketsMapper;

    @Autowired
    private BaseConverter<TicketRequest, Tickets> requestConverter;
    @Override
    public Tickets getTicketById(Integer id) throws Exception {
        return this.ticketsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateTicket(TicketRequest ticketRequest) throws Exception {
        Tickets tickets = this.requestConverter.convert(ticketRequest,Tickets.class);
        return this.ticketsMapper.updateByPrimaryKey(tickets);
    }

    @Override
    public int deleteTicketById(Integer id) throws Exception {
        return this.ticketsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveTickets(TicketRequest ticketRequest) throws Exception {
        Tickets tickets = this.requestConverter.convert(ticketRequest,Tickets.class);
        return this.ticketsMapper.insert(tickets);
    }
}
