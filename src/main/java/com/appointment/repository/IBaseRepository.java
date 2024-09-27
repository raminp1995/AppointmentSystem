package com.appointment.repository;

import com.appointment.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@NoRepositoryBean
public interface IBaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Long>
{

}
