package com.kishore.event.email;

import com.kishore.event.customer.Customer;
import com.kishore.event.order.Order;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailService
{
	@Async
    public void sendRegisterEmail(Customer customer)
    {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("Sending registration email to customer {}", customer);
    }

    public void sendCustomerRemovedEmail(Customer customer)
    {
        log.info("Sending removed email for customer {}", customer);
    }
    
   @Async
    public void sendOrderEmail(Order order)
    {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("------------------------------------->>>>>>>>>>>>>>>>>>>> Sending email for order {}", order);
    }
}
