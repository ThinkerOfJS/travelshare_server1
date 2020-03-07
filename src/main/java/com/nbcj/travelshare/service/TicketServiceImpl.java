package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Ticket;
import com.nbcj.travelshare.mapper.TicketMapper;

import javax.annotation.Resource;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    @Resource
    TicketMapper ticketMapper;

    @Override
    public List<Ticket> getTicketBySid(Integer sid) {
        return ticketMapper.getTicketBySid(sid);
    }
}
