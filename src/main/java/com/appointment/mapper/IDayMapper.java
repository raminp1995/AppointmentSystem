package com.appointment.mapper;

import com.appointment.model.dto.DayDto;
import com.appointment.model.entity.DayEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IDayMapper extends IBaseMapper<DayEntity, DayDto>
{
}
