package com.appointment.model.entity;

import com.appointment.constant.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "reservationTable")
public class ReservationEntity extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "businessOwnerId")
    private BusinessOwnerEntity businessOwnerId;

    @ManyToOne
    private CustomerEntity customerId;

    @DateTimeFormat
    private LocalDate reserveDay;

    @DateTimeFormat
    private LocalTime reserveHour;

    @Enumerated
    private ReservationStatus reservationStatus;

    @ManyToOne(targetEntity = ServicesEntity.class, fetch = FetchType.EAGER)
    private ServicesEntity servicesEntity;

    private Boolean isAccepted;
}
