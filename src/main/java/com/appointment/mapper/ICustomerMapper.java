package com.appointment.mapper;

import com.appointment.mapper.ICustomerMapper;
import com.appointment.model.dto.CustomerDto;
import com.appointment.model.entity.CustomerEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ICustomerMapper extends IBaseMapper<CustomerEntity, CustomerDto>
{
}
