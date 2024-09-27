package com.appointment.service;

import com.appointment.exception.ReservedAppointmentException;
import com.appointment.exception.UserNotFoundException;
import com.appointment.mapper.IBaseMapper;
import com.appointment.mapper.ICustomerMapper;
import com.appointment.model.dto.BillDto;
import com.appointment.model.dto.CustomerDto;
import com.appointment.model.dto.ReservationDto;
import com.appointment.model.entity.CustomerEntity;
import com.appointment.repository.IBaseRepository;
import com.appointment.repository.ICustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDto>
{
    private final ICustomerRepository customerRepository;
    private final ICustomerMapper customerMapper;
    private final ReservationService reservationService;

    protected CustomerService(IBaseRepository<CustomerEntity> repository, IBaseMapper<CustomerEntity, CustomerDto> mapper, ICustomerRepository customerRepository, ICustomerMapper customerMapper, ReservationService reservationService)
    {
        super(repository, mapper);
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.reservationService = reservationService;
    }


    @Override
    public ResponseEntity<CustomerDto> getById(Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @Override
    public ResponseEntity<CustomerDto> save(CustomerDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @Override
    public ResponseEntity<CustomerDto> update(CustomerDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @Override
    public ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }

    public ResponseEntity<ReservationDto> reserveAppointment(ReservationDto dto) throws UserNotFoundException, ReservedAppointmentException
    {
        CustomerEntity customer = customerRepository.findByUsername(dto.getCustomerUsername()).orElse(null);

        if (customer == null)
        {
            throw new UserNotFoundException();
        }
        else
        {
            dto.setCustomerId(customerMapper.entityToDto(customer));
            return reservationService.reserve(dto);
        }
    }

    public ResponseEntity<List<BillDto>> getBills (Long customerId)
    {
        return null;
    }

    public ResponseEntity<List<ReservationDto>> getReservations (Long customerId)
    {
        return null;
    }
}
