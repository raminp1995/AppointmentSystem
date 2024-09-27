package com.appointment.controller;

import com.appointment.exception.UserNotFoundException;
import com.appointment.model.dto.ReservationDto;
import com.appointment.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserves")
public class ReservationController extends BaseController<ReservationService, ReservationDto>
{
    protected ReservationController(ReservationService service)
    {
        super(service);
    }

    @GetMapping("/getById/{id}")
    @Override
    public ResponseEntity<ReservationDto> getById(@PathVariable Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<ReservationDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<ReservationDto> save(@RequestBody ReservationDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<ReservationDto> update(@RequestBody ReservationDto dto) throws UserNotFoundException
    {
        return super.update(dto);
    }

    @DeleteMapping("/remove/{id}")
    @Override
    public ResponseEntity<Boolean> remove(@PathVariable Long id) throws UserNotFoundException
    {
        return super.remove(id);
    }
}
