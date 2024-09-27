package com.appointment.model.dto;

import com.appointment.model.entity.BusinessOwnerEntity;
import com.appointment.model.entity.ReservationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NotificationDto extends BaseDto
{
    private ReservationDto reservation;

    private BusinessOwnerDto businessOwner;

    private Boolean isSeen;
}
