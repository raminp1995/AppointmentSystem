package com.appointment.controller;


import com.appointment.exception.UserNotFoundException;
import com.appointment.model.dto.*;
import com.appointment.service.BusinessOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/businessOwners")
public class BusinessOwnerController extends BaseController<BusinessOwnerService, BusinessOwnerDto>
{
    private final BusinessOwnerService businessOwnerService;

    protected BusinessOwnerController(BusinessOwnerService service, BusinessOwnerService businessOwnerService)
    {
        super(service);
        this.businessOwnerService = businessOwnerService;
    }

    @GetMapping("/getById/{id}")
    @Override
    public ResponseEntity<BusinessOwnerDto> getById(@PathVariable Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<BusinessOwnerDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<BusinessOwnerDto> save(@RequestBody BusinessOwnerDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<BusinessOwnerDto> update(@RequestBody BusinessOwnerDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @DeleteMapping("/remove/{id}")
    @Override
    public ResponseEntity<Boolean> remove(@PathVariable Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }

    @PostMapping("/setOrEditWorkTime")
    public ResponseEntity<WorkingTimeDto> setOrEditWorkTime(@RequestBody WorkingTimeDto workingTimeDto) throws UserNotFoundException
    {
         return businessOwnerService.setOrEditWorkTime(workingTimeDto);
    }

    @GetMapping("/removeWorkTime/{username}")
    public ResponseEntity<Boolean> removeWorkTime(@PathVariable String username) throws UserNotFoundException
    {
        return businessOwnerService.removeWorkTime(username);
    }

    @GetMapping("/getCustomers/{username}")
    public ResponseEntity<Set<CustomerDto>> getCustomers(@PathVariable String username) throws UserNotFoundException
    {
        return businessOwnerService.getCustomers(username);
    }

    @GetMapping("/getReservations/{username}")
    public ResponseEntity<List<ReservationDto>> getReservesList(@PathVariable String username) throws UserNotFoundException
    {
        return businessOwnerService.getReservesList(username);
    }

    @DeleteMapping("/cancelReservation/{username}&{reservationId}")
    public ResponseEntity<Boolean> cancelReservation(@PathVariable String username, @PathVariable Long reservationId) throws UserNotFoundException
    {
        return businessOwnerService.cancelReservation(username, reservationId);
    }

    @GetMapping("/getDailyIncome/{username}")
    public ResponseEntity<Double> dailyIncome(@PathVariable String username) throws UserNotFoundException
    {
        return businessOwnerService.dailyIncome(username);
    }

    @GetMapping("/getWeeklyIncome/{username}")
    public ResponseEntity<Double> weeklyIncome(@PathVariable String username) throws UserNotFoundException
    {
        return businessOwnerService.weeklyIncome(username);
    }

    @GetMapping("/getMonthlyIncome/{username}")
    public ResponseEntity<Double> monthlyIncome(@PathVariable String username) throws UserNotFoundException
    {
        return businessOwnerService.monthlyIncome(username);
    }

    @PostMapping("/setServices/{username}")
    public ResponseEntity<ServicesDto> setServices(@PathVariable String username, @RequestBody ServicesDto servicesDto) throws UserNotFoundException
    {
        return businessOwnerService.setServices(username, servicesDto);
    }
}
