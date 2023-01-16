package com.kishore.event.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.kishore.event.order.OrderCompletedEvent;

@Component
@RequiredArgsConstructor
public class TicketOrderFailedListener
{

    private final TicketService ticketService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void onOrderCompletedEvent(OrderCompletedEvent event)
    {
        ticketService.createTicket(event.getOrder());
    }
}
