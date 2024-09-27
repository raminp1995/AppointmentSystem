package com.appointment.mapper;


import com.appointment.model.dto.BaseDto;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;

@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface IBaseMapper<Entity extends com.appointment.model.entity.BaseEntity, Dto extends BaseDto>
{
    Entity dtoToEntity(Dto dto);

    Dto entityToDto(Entity entity);
}
