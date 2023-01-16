package com.kishore.event.analytics;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.kishore.event.customer.Customer;

import static java.lang.Thread.sleep;

@Slf4j
@Component
public class AnalyticsService
{

    @SneakyThrows
    public void registerNewCustomer(Customer customer)
    {
        log.info("calling analytics service for customer {}", customer);
        sleep(5_000);
    }
}
