package com.appointment.service;

import com.appointment.mapper.IBaseMapper;
import com.appointment.model.Hour;
import com.appointment.model.dto.DayDto;
import com.appointment.model.entity.DayEntity;
import com.appointment.repository.IBaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class DayService extends BaseService<DayEntity, DayDto>
{
    protected DayService(IBaseRepository<DayEntity> repository, IBaseMapper<DayEntity, DayDto> mapper)
    {
        super(repository, mapper);
    }


    public List<Hour> setTimeSlot(LocalTime startTime, LocalTime endTime, Integer duration)
    {
        // Generate hourly slots between startTime and endTime
        List<Hour> hours = new ArrayList<>();
        LocalTime currentTime = startTime.truncatedTo(ChronoUnit.HOURS);
        while (!currentTime.isAfter(endTime))
        {
            hours.add(new Hour(currentTime));
            currentTime = currentTime.plusMinutes(duration);
        }

        return hours;
    }

}
