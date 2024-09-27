package com.appointment.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class BaseDto
{
    @JsonIgnore
    protected Long id;
    @JsonIgnore
    protected LocalDateTime created_at;
    @JsonIgnore
    protected LocalDateTime updated_at;
    @JsonIgnore
    protected Boolean isDeleted = false;
}
