package com.appointment.service;

import com.appointment.constant.ReservationStatus;
import com.appointment.exception.ReservedAppointmentException;
import com.appointment.exception.UserNotFoundException;
import com.appointment.mapper.IBaseMapper;
import com.appointment.mapper.ICustomerMapper;
import com.appointment.mapper.IReservationMapper;
import com.appointment.model.Hour;
import com.appointment.model.dto.ReservationDto;
import com.appointment.model.entity.BusinessOwnerEntity;
import com.appointment.model.entity.DayEntity;
import com.appointment.model.entity.ReservationEntity;
import com.appointment.repository.IBaseRepository;
import com.appointment.repository.IBusinessOwnerRepository;
import com.appointment.repository.IReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService extends BaseService<ReservationEntity, ReservationDto>
{
    private final IReservationRepository reservationRepository;
    private final IReservationMapper reservationMapper;
    private final IBusinessOwnerRepository businessOwnerRepository;
    private final ICustomerMapper customerMapper;

    protected ReservationService(IBaseRepository<ReservationEntity> repository
            , IBaseMapper<ReservationEntity
            , ReservationDto> mapper
            , IReservationRepository reservationRepository, IReservationMapper reservationMapper
            , IBusinessOwnerRepository businessOwnerRepository
            , ICustomerMapper customerMapper)
    {
        super(repository, mapper);
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.businessOwnerRepository = businessOwnerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseEntity<ReservationDto> getById(Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<ReservationDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @Override
    public ResponseEntity<ReservationDto> save(ReservationDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @Override
    public ResponseEntity<ReservationDto> update(ReservationDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @Override
    public ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }

    public ResponseEntity<ReservationDto> reserve (ReservationDto dto) throws UserNotFoundException, ReservedAppointmentException
    {
        BusinessOwnerEntity boe = businessOwnerRepository.findByUsername(dto.getBusinessOwnerUsername()).orElseThrow(UserNotFoundException::new);

        DayEntity day = boe.getWorkingTimes().getDays()
                .stream().filter(i -> i.getDay().equals(dto.getReserveDay()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        Hour reserveHour = day.getHours()
                .stream().filter(i -> i.getTime().equals(dto.getReserveHour()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        if (!reserveHour.isReserved())
        {
            reserveHour.setReserved(true);
        }
        else
        {
            throw new ReservedAppointmentException();
        }

        ReservationEntity reservationEntity = ReservationEntity.builder()
                .reservationStatus(ReservationStatus.TAKEN)
                .businessOwnerId(boe)
                .customerId(customerMapper.dtoToEntity(dto.getCustomerId()))
                .reserveHour(reserveHour.getTime())
                .isAccepted(true)
                .reserveDay(day.getDay())
                .build();

        reservationRepository.save(reservationEntity);
        ReservationDto reservationDto = reservationMapper.entityToDto(reservationEntity);
        reservationDto.setBusinessOwnerUsername(boe.getUsername());
        reservationDto.setCustomerUsername(dto.getCustomerUsername());

        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }
}
