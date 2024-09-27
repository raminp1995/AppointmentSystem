package com.appointment.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "notificationTable")
public class NotificationEntity extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "reservation")
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "businessOwner")
    private BusinessOwnerEntity businessOwner;

    private Boolean isSeen;
}
