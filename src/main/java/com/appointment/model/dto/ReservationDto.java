package com.appointment.model.dto;

import com.appointment.constant.ReservationStatus;
import com.appointment.model.entity.BusinessOwnerEntity;
import com.appointment.model.entity.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReservationDto extends BaseDto
{
    @JsonIgnore
    private BusinessOwnerDto businessOwnerId;
    @JsonIgnore
    private CustomerDto customerId;

    private String businessOwnerUsername;
    private String customerUsername;
    private LocalDate reserveDay;
    private LocalTime reserveHour;
    private ReservationStatus reservationStatus;
    private Boolean isAccepted;
}
