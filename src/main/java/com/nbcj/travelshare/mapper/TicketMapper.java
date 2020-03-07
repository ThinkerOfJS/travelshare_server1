package com.nbcj.travelshare.mapper;

import com.nbcj.travelshare.domain.Ticket;

import java.util.List;

public interface TicketMapper {
    List<Ticket> getTicketBySid(Integer sid);
}
