package com.appointment.mapper;

import com.appointment.model.dto.WorkingTimeDto;
import com.appointment.model.entity.WorkingTimeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IWorkingTimeMapper extends IBaseMapper<WorkingTimeEntity, WorkingTimeDto>
{
}
