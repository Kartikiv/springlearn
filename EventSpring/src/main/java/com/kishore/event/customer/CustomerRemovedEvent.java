package com.kishore.event.customer;

import lombok.Data;

@Data
public class CustomerRemovedEvent
{
    private final Customer customer;
}
