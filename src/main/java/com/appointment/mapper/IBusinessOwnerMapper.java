package com.appointment.mapper;

import com.appointment.model.dto.BusinessOwnerDto;
import com.appointment.model.entity.BusinessOwnerEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IBusinessOwnerMapper extends IBaseMapper<BusinessOwnerEntity, BusinessOwnerDto>
{
}
