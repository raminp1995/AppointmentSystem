package com.appointment.model.dto;

import com.appointment.model.entity.BillEntity;
import com.appointment.model.entity.ReservationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerDto extends PersonDto
{
    private List<ReservationEntity> reservationEntity;
    private List<BillEntity> billEntityList;
    private Float popularity;
}
