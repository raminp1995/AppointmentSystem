package com.appointment.service;

import com.appointment.exception.UserNotFoundException;
import com.appointment.mapper.*;
import com.appointment.model.dto.*;
import com.appointment.model.entity.BillEntity;
import com.appointment.model.entity.BusinessOwnerEntity;
import com.appointment.model.entity.DayEntity;
import com.appointment.repository.IBaseRepository;
import com.appointment.repository.IBusinessOwnerRepository;
import com.appointment.repository.IWorkingTimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BusinessOwnerService extends BaseService<BusinessOwnerEntity, BusinessOwnerDto>
{
    private final IBusinessOwnerRepository businessOwnerRepository;
    private final IWorkingTimeRepository workingTimeRepository;
    private final IBusinessOwnerMapper businessOwnerMapper;
    private final IWorkingTimeMapper workingTimeMapper;
    private final ICustomerMapper customerMapper;
    private final IReservationMapper reservationMapper;
    private final IServicesMapper servicesMapper;
    private final DayService dayService;

    protected BusinessOwnerService(IBaseRepository<BusinessOwnerEntity> repository,
                                   IBaseMapper<BusinessOwnerEntity, BusinessOwnerDto> mapper,
                                   IBusinessOwnerRepository businessOwnerRepository, IWorkingTimeRepository workingTimeRepository,
                                   IBusinessOwnerMapper businessOwnerMapper,
                                   IWorkingTimeMapper workingTimeMapper, IWorkingTimeMapper workingTimeMapper1,
                                   ICustomerMapper customerMapper,
                                   IReservationMapper reservationMapper,
                                   IServicesMapper servicesMapper, IDayMapper dayMapper, DayService dayService)
    {
        super(repository, mapper);
        this.businessOwnerRepository = businessOwnerRepository;
        this.workingTimeRepository = workingTimeRepository;
        this.businessOwnerMapper = businessOwnerMapper;
        this.workingTimeMapper = workingTimeMapper1;
//        this.workingTimeMapper = workingTimeMapper;
        this.customerMapper = customerMapper;
        this.reservationMapper = reservationMapper;
        this.servicesMapper = servicesMapper;
        this.dayService = dayService;
    }

    @Override
    public ResponseEntity<BusinessOwnerDto> getById(Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<BusinessOwnerDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @Override
    public ResponseEntity<BusinessOwnerDto> save(BusinessOwnerDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @Override
    public ResponseEntity<BusinessOwnerDto> update(BusinessOwnerDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @Override
    public ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }

    public ResponseEntity<BusinessOwnerDto> findByUsername(String username) throws UserNotFoundException
    {
        BusinessOwnerDto boe = businessOwnerMapper.entityToDto(businessOwnerRepository.findByUsername(username).orElseThrow(UserNotFoundException::new));
        return new ResponseEntity<>(boe, HttpStatus.OK);
    }

    public ResponseEntity<WorkingTimeDto> setOrEditWorkTime(WorkingTimeDto workingTimeDto) throws UserNotFoundException
    {
        BusinessOwnerEntity boe = businessOwnerMapper.dtoToEntity(findByUsername(workingTimeDto.getUsername()).getBody());

        List<DayDto> days = workingTimeDto.getDays();

        LocalTime startTime = days.stream().findFirst().get().getStartTime();
        LocalTime endTime = days.stream().findFirst().get().getEndTime();
        Integer duration = days.stream().findFirst().get().getDuration();

        days.forEach(i -> i.setHours(dayService.setTimeSlot(startTime, endTime, duration)));

        workingTimeDto.setDays(days);

        if (boe.getWorkingTimes() == null)
        {
            boe.setWorkingTimes(workingTimeMapper.dtoToEntity(workingTimeDto));
        }
        else
        {
            workingTimeRepository.deleteById(boe.getWorkingTimes().getId());
            boe.setWorkingTimes(workingTimeMapper.dtoToEntity(workingTimeDto));
        }
        businessOwnerRepository.save(boe);
        return new ResponseEntity<>(workingTimeDto, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> removeWorkTime(String username) throws UserNotFoundException
    {
        BusinessOwnerEntity boe = businessOwnerMapper.dtoToEntity(findByUsername(username).getBody());
        boe.setWorkingTimes(null);
        businessOwnerRepository.save(boe);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public ResponseEntity<Set<CustomerDto>> getCustomers(String username) throws UserNotFoundException
    {
        BusinessOwnerEntity bod = businessOwnerMapper.dtoToEntity(findByUsername(username).getBody());
        Set<CustomerDto> customersList = bod.getCustomers().stream()
                .map(customerMapper::entityToDto).collect(Collectors.toSet());

        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> acceptReservation(NotificationDto notification)
    {
        return null;
    }

    public ResponseEntity<List<ReservationDto>> getReservesList(String username) throws UserNotFoundException
    {
        BusinessOwnerEntity boe = businessOwnerRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        List<ReservationDto> reservationsList = boe.getReservationList().stream().map(reservationMapper::entityToDto).toList();
        return new ResponseEntity<>(reservationsList, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> cancelReservation(String username, Long reservationId) throws UserNotFoundException
    {
        BusinessOwnerEntity boe = businessOwnerRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        boe.getReservationList().stream().filter(i -> i.getId().equals(reservationId)).findFirst().get().setIsDeleted(true);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public ResponseEntity<Double> dailyIncome(String username) throws UserNotFoundException
    {
        /* Gets All BOE's Bills */
        List<BillEntity> billList = businessOwnerRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new).getBillList();

        /* Gets Today's Bills */
        List<BillEntity> todayPaidBills = billList.stream()
                .filter(i -> i.getCreated_at().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()
                        && i.getIsPaid().equals(true)).toList();

        Double sum = todayPaidBills.stream().mapToDouble(i -> i.getAmount()).sum();

        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    public ResponseEntity<Double> weeklyIncome(String username) throws UserNotFoundException
    {
        /* Gets All BOE's Bills */
        List<BillEntity> billList = businessOwnerRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new).getBillList();

        /* Gets a Week's Bills */
        List<BillEntity> todayPaidBills = billList.stream()
                .filter(i -> i.getCreated_at().toLocalDate().equals(LocalDateTime.now().minusWeeks(1))
                        && i.getIsPaid().equals(true)).toList();


        Double sum = todayPaidBills.stream().mapToDouble(i -> i.getAmount()).sum();
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    public ResponseEntity<Double> monthlyIncome(String username) throws UserNotFoundException
    {
        List<BillEntity> billList = businessOwnerRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new).getBillList();

        /* Gets a Week's Bills */
        List<BillEntity> todayPaidBills = billList.stream()
                .filter(i -> i.getCreated_at().getMonth().equals(LocalDateTime.now().getMonth())
                        && i.getIsPaid().equals(true)).toList();


        Double sum = todayPaidBills.stream().mapToDouble(i -> i.getAmount()).sum();
        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

    public ResponseEntity<ServicesDto> setServices(String username, ServicesDto servicesDto) throws UserNotFoundException
    {
        BusinessOwnerEntity boe = businessOwnerRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        boe.getServicesList().add(servicesMapper.dtoToEntity(servicesDto));
        return new ResponseEntity<>(servicesDto, HttpStatus.OK);
    }

    public ResponseEntity<ServicesDto> editServices(ServicesDto servicesDto)
    {
        return null;
    }

    public ResponseEntity<Boolean> removeServices(Long servicesId)
    {
        return null;
    }
}
