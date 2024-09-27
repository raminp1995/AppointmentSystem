package com.appointment.controller;

import com.appointment.exception.ReservedAppointmentException;
import com.appointment.exception.UserNotFoundException;
import com.appointment.model.dto.CustomerDto;
import com.appointment.model.dto.ReservationDto;
import com.appointment.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController<CustomerService, CustomerDto>
{
    private final CustomerService customerService;

    protected CustomerController(CustomerService service, CustomerService customerService)
    {
        super(service);
        this.customerService = customerService;
    }

    @GetMapping("/getById/{id}")
    @Override
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<CustomerDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @DeleteMapping("/remove/{id}")
    @Override
    public ResponseEntity<Boolean> remove(@PathVariable Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }

    @PostMapping("/reserveAppointment")
    public ResponseEntity<ReservationDto> reserveAppointment (@RequestBody ReservationDto dto) throws UserNotFoundException, ReservedAppointmentException
    {
        return customerService.reserveAppointment(dto);
    }
}
