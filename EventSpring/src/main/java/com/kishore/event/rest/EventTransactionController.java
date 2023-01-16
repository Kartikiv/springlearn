package com.kishore.event.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.event.customer.Customer;
import com.kishore.event.customer.CustomerService;
import com.kishore.event.order.Order;
import com.kishore.event.order.OrderService;

@RestController
public class EventTransactionController {
	
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private OrderService orderService;


    @PostMapping("/register")
    void registerCustomer(@RequestBody Customer customer){
	        customerService.register(customer);
    }
    
    @PostMapping("/placeorder")
    void placeOrder(@RequestBody Order order){
	        orderService.placeOrder(order);
    }

    
    @GetMapping("/getorders")
    List<Order> getOrders(){
	       return orderService.getOrders();
    }
    
    
    @GetMapping("/getcustomers")
    List<Customer> getCustomers(){
	       return customerService.getCustomers();
    }
}
