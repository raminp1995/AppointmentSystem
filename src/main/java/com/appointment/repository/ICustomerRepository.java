package com.appointment.repository;

import com.appointment.model.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends IBaseRepository<CustomerEntity>
{
    Optional<CustomerEntity> findByUsername(String username);
}
