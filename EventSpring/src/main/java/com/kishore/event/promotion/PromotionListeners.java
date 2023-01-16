package com.kishore.event.promotion;

import com.kishore.event.customer.CustomerRegisteredEvent;
import com.kishore.event.order.OrderCompletedEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionListeners
{

    private final PromotionService promotionService;

    @EventListener
    public void onRegistrationEvent (CustomerRegisteredEvent event)
    {
        promotionService.applyPromotion(event.getCustomer());
    }

    @EventListener
    public void onOrderCompleted(OrderCompletedEvent event)
    {
        promotionService.calculateRewardPoints(event.getOrder());
    }
}


//(condition = "#event.customer.newsletter")