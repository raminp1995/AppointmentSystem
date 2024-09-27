package com.appointment.model.entity;

import com.appointment.constant.PaymentMethods;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "billTable")
public class BillEntity extends BaseEntity
{
    @ManyToOne
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "businessOwnerId")
    private BusinessOwnerEntity businessOwnerId;

    private Double amount;

    @Enumerated
    private PaymentMethods paymentMethod;

    private Boolean isPaid;
}
