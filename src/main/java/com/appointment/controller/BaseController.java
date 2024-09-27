package com.appointment.controller;

import com.appointment.model.dto.BaseDto;
import com.appointment.exception.UserNotFoundException;
import com.appointment.service.IBaseService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController<Service extends IBaseService<Dto>, Dto extends BaseDto> implements com.appointment.service.IBaseService<Dto>
{
    private final Service service;

    protected BaseController(Service service)
    {
        this.service = service;
    }

    @Override
    public ResponseEntity<Dto> getById(Long id) throws UserNotFoundException
    {
        return service.getById(id);
    }

    @Override
    public ResponseEntity<List<Dto>> getAll() throws UserNotFoundException
    {
        return service.getAll();
    }

    @Override
    public ResponseEntity<Dto> save(Dto dto) throws UserNotFoundException
    {
        return service.save(dto);
    }

    @Override
    public ResponseEntity<Dto> update(Dto dto) throws UserNotFoundException
    {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException
    {
        return service.remove(id);
    }
}
