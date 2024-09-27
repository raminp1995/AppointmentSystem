package com.appointment.mapper;

import com.appointment.model.dto.ReservationDto;
import com.appointment.model.entity.ReservationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IReservationMapper extends IBaseMapper<ReservationEntity, ReservationDto>
{
}
