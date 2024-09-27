package com.appointment.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "customerTable")
public class CustomerEntity extends PersonEntity
{
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationEntity;

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<BillEntity> billEntityList = new ArrayList<>();

    private Float popularity;
}
