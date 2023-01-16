package com.kishore.event.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.kishore.event.order.Order;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer
{
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private boolean newsletter;

    @Column(columnDefinition = "DECIMAL(2)")
    private BigDecimal rewardPoints;


    public Customer(String email)
    {
        this.email = email;
    }
}
