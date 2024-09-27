package com.appointment.model;

import com.appointment.model.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Hour extends BaseEntity
{
    // Get the LocalDateTime for this hour
    private LocalTime time; // LocalTime for this hour

    // Check if the hour is reserved
    private boolean reserved; // If true, the hour is reserved (busy)

    public Hour(LocalTime time) {
        this.time = time;
        this.reserved = false; // By default, hour is free
    }

    // Reserve the hour
    public void reserve() {
        this.reserved = true;
    }

    // UnReserve the hour
    public void unReserve() {
        this.reserved = false;
    }
}
