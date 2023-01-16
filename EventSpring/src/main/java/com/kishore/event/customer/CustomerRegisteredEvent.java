package com.kishore.event.customer;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CustomerRegisteredEvent
{
    private final Customer customer;
}
