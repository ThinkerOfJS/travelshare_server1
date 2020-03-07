package com.nbcj.travelshare.service;

import com.nbcj.travelshare.domain.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getTicketBySid(Integer sid);
}
