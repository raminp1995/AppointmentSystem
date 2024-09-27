package com.appointment.mapper;

import com.appointment.model.dto.ServicesDto;
import com.appointment.model.entity.ServicesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IServicesMapper extends IBaseMapper<ServicesEntity, ServicesDto>
{
}
