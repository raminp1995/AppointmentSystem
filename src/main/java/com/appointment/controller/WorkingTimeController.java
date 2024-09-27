package com.appointment.controller;

import com.appointment.exception.UserNotFoundException;
import com.appointment.model.dto.WorkingTimeDto;
import com.appointment.service.WorkingTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workingTimes")
public class WorkingTimeController extends BaseController<WorkingTimeService, WorkingTimeDto>
{
    protected WorkingTimeController(WorkingTimeService service)
    {
        super(service);
    }

    @GetMapping("/getById/{id}")
    @Override
    public ResponseEntity<WorkingTimeDto> getById(@PathVariable Long id) throws UserNotFoundException
    {
        return super.getById(id);
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<WorkingTimeDto>> getAll() throws UserNotFoundException
    {
        return super.getAll();
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<WorkingTimeDto> save(@RequestBody WorkingTimeDto dto) throws UserNotFoundException
    {
        return super.save(dto);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<WorkingTimeDto> update(@RequestBody WorkingTimeDto dto) throws UserNotFoundException
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
