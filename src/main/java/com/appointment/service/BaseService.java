package com.appointment.service;

import com.appointment.exception.UserNotFoundException;
import com.appointment.mapper.IBaseMapper;
import com.appointment.model.dto.BaseDto;
import com.appointment.model.entity.BaseEntity;
import com.appointment.repository.IBaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseService<Entity extends BaseEntity, Dto extends BaseDto> implements IBaseService<Dto>
{
    private final IBaseRepository<Entity> repository;
    private final IBaseMapper<Entity, Dto> mapper;

    protected BaseService(IBaseRepository<Entity> repository, IBaseMapper<Entity, Dto> mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Dto> getById(Long id) throws UserNotFoundException
    {
        return new ResponseEntity<>(mapper.entityToDto(repository.findById(id)
                        .orElseThrow(UserNotFoundException::new)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Dto>> getAll() throws UserNotFoundException
    {
        List<Dto> dtoList = repository.findAll()
                .stream().filter(i -> !i.getIsDeleted())
                .map(mapper::entityToDto)
                .toList();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> save(Dto dto) throws UserNotFoundException
    {
        return new ResponseEntity<>(
                mapper.entityToDto(repository.save(mapper.dtoToEntity(dto))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Dto> update(Dto dto) throws UserNotFoundException
    {
        Entity entity = repository.findById(dto.getId()).orElseThrow(UserNotFoundException::new);
        entity.setUpdated_at(LocalDateTime.now());
        if (!entity.getIsDeleted())
        {
            copyNonNullProperties(dto, entity);
            return new ResponseEntity<>(mapper.entityToDto(repository.save(entity)), HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<Boolean> remove(Long id) throws UserNotFoundException
    {
        Entity entity = repository.findById(id).orElseThrow(() -> new UserNotFoundException());
        if (entity.getIsDeleted())
        {
            throw new UserNotFoundException();
        }
        else
        {
            entity.setIsDeleted(true);
            repository.save(entity);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }


    public static void copyNonNullProperties(Object source, Object target)
    {
        BeanUtils.copyProperties(source, target, getNullPropertyName(source));
    }

    public static String[] getNullPropertyName(Object source)
    {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds)
        {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
            {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
