package com.appointment.service;

import com.appointment.exception.UserNotFoundException;
import com.appointment.model.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseService <Dto extends BaseDto>
{
    ResponseEntity<Dto> getById(Long id) throws UserNotFoundException;
    ResponseEntity<List<Dto>> getAll() throws UserNotFoundException;
    ResponseEntity<Dto> save(Dto dto) throws UserNotFoundException;
    ResponseEntity<Dto> update(Dto dto) throws UserNotFoundException;
    ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException;

}
