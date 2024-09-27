package com.appointment.repository;

import com.appointment.model.entity.BusinessOwnerEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBusinessOwnerRepository extends IBaseRepository<BusinessOwnerEntity>
{
    Optional<BusinessOwnerEntity> findByUsername(String username);
}
