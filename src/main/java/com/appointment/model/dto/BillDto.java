package com.appointment.model.dto;

import com.appointment.constant.PaymentMethods;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BillDto extends BaseDto
{
    private CustomerDto customerEntity;

    private BusinessOwnerDto businessOwnerId;

    private Double amount;

    private PaymentMethods paymentMethod;

    private Boolean isPaid;
}
