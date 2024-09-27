package com.appointment.mapper;

import com.appointment.model.dto.NotificationDto;
import com.appointment.model.entity.NotificationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface INotificationMapper extends IBaseMapper<NotificationEntity, NotificationDto>
{
}
