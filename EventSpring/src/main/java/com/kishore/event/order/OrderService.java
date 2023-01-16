package com.kishore.event.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.kishore.event.order.Order.OrderStatus.COMPLETED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.event.promotion.PromotionService;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderService
{
    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher publisher;
    
    @Autowired
    private PromotionService promotionService;

   @Transactional
    public void placeOrder(Order order)
    {
        log.info("Placing and order {}", order);
        order.setStatus(COMPLETED);
        orderRepository.save(order);

    
        log.info("Publishing order completed event");
        publisher.publishEvent(new OrderCompletedEvent(order));
    }
    
    
    public List<Order> getOrders()
    {
    	return orderRepository.findAll();
    }
}
