package com.kishore.event.analytics;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.kishore.event.customer.CustomerRegisteredEvent;

@Component
@RequiredArgsConstructor
public class AnalyticsCustomerRegisteredListener
{
	@Autowired
    private final AnalyticsService analyticsService;

    @Async
    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event)
    {
        analyticsService.registerNewCustomer(event.getCustomer());

    }
}
