package com.kishore.event.ticket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.kishore.event.order.Order;

@Slf4j
@Component
public class TicketService
{

    public void createTicket(Order order)
    {
        log.info("Creating ticket for helpdesk service for order {}", order);
    }
}
