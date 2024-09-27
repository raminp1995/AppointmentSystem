package com.appointment.service;

import com.appointment.exception.UserNotFoundException;
import com.appointment.mapper.IBaseMapper;
import com.appointment.mapper.IWorkingTimeMapper;
import com.appointment.model.dto.WorkingTimeDto;
import com.appointment.model.entity.DayEntity;
import com.appointment.model.entity.WorkingTimeEntity;
import com.appointment.repository.IBaseRepository;
import com.appointment.repository.IWorkingTimeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeService extends BaseService<WorkingTimeEntity, WorkingTimeDto>
{

    private final IWorkingTimeRepository workingTimeRepository;
    private final IWorkingTimeMapper workingTimeMapper;

    public WorkingTimeService(IBaseRepository<WorkingTimeEntity> repository, IBaseMapper<WorkingTimeEntity, WorkingTimeDto> mapper, IWorkingTimeRepository workingTimeRepository, IWorkingTimeMapper workingTimeMapper)
    {
        super(repository, mapper);
        this.workingTimeRepository = workingTimeRepository;
        this.workingTimeMapper = workingTimeMapper;
    }

    @Override
    public ResponseEntity<WorkingTimeDto> getById(Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<WorkingTimeDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @Override
    public ResponseEntity<WorkingTimeDto> save(WorkingTimeDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @Override
    public ResponseEntity<WorkingTimeDto> update(WorkingTimeDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @Override
    public ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }

//    // Add a new day with working hours (defined by startTime and endTime)
//    public void addDay(LocalTime startTime, LocalTime endTime) {
//        days.add(new Day(startTime, endTime));
//    }
//
//    // Reserve an hour by its exact LocalDateTime
//    public boolean reserveHour(LocalTime time) {
//        for (Day day : days) {
//            if (day.reserveHour(time)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Unreserve an hour by its exact LocalDateTime
//    public boolean unReserveHour(LocalTime time) {
//        for (Day day : days) {
//            if (day.unReserveHour(time)) {
//                return true;
//            }
//        }
//        return false;
}
