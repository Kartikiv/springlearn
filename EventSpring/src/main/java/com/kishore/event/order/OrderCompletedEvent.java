package com.kishore.event.order;

import lombok.Data;

@Data
public class OrderCompletedEvent
{
    private final Order order;
}
