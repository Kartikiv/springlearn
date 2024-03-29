package com.kishore.event.email;

import com.kishore.event.customer.CustomerRegisteredEvent;
import com.kishore.event.customer.CustomerRemovedEvent;
import com.kishore.event.order.OrderCompletedEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners
{
    private final EmailService emailService;

    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event)
    {
        emailService.sendRegisterEmail(event.getCustomer());
    }

    @EventListener
    public void onCustomerRemovedEvent(CustomerRemovedEvent event)
    {
        emailService.sendCustomerRemovedEmail(event.getCustomer());
    }

    
    @EventListener
   public void onOrderCompletedEvent(OrderCompletedEvent event)
    {
        emailService.sendOrderEmail(event.getOrder());
    }

}


//@TransactionalEventListener
