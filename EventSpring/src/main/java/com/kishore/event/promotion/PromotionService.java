package com.kishore.event.promotion;

import com.kishore.event.customer.Customer;
import com.kishore.event.customer.CustomerRepository;
import com.kishore.event.order.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

@Slf4j
@RequiredArgsConstructor
@Component
public class PromotionService
{
    private final CustomerRepository customerRepository;

    public void applyPromotion(Customer customer)
    {
        log.info("Apply free gift for a customer {}", customer);
    }

    public void calculateRewardPoints(Order order)
    {
    	Long customerId = order.getCustomer().getId();
    	Customer customer = order.getCustomer();
      //  Customer customer = customerRepository.findById(customerId).get();

        //for each order entry (product + quantity) gather reward status points
        //for simulation we will append 10 points per order
        
        System.out.println(" the customer is ----->>>> "+customer);
        
        if (customer.getRewardPoints() == null)
        	customer.setRewardPoints(BigDecimal.ZERO);
        
        BigDecimal newRewardPoints = customer.getRewardPoints().add(TEN);
        
    //    if (customer.getEmail().startsWith("abcde"))  throw new RuntimeException(" Error ");
        
        customer.setRewardPoints(newRewardPoints);
        customerRepository.save(customer);
        log.info("Customer {}, reward points old: {}, new: {}", customer.getId(), customer.getRewardPoints(), newRewardPoints);
    }
    
    
}
