package com.appointment.model.entity;

import com.appointment.constant.Jobs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "businessOwnerTable")
public class BusinessOwnerEntity extends PersonEntity
{
    private String placeName;
    private String registrationNumber;
    private String businessLicence;
    private String certification;

    @Enumerated
    private Jobs jobType;

    //@ElementCollection
    @OneToMany(targetEntity = CustomerEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "customers")
    private Set<CustomerEntity> customers = new HashSet<>();

    @OneToOne(targetEntity = WorkingTimeEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "working_time_id", referencedColumnName = "id")
    private WorkingTimeEntity workingTimes = new WorkingTimeEntity();

    private Float popularity;

    @OneToMany(mappedBy = "businessOwnerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReservationEntity> reservationList = new ArrayList<>();

    @OneToMany(targetEntity = ServicesEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ServicesEntity> servicesList = new ArrayList<>();

    @OneToMany(targetEntity = NotificationEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NotificationEntity> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "businessOwnerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BillEntity> billList = new ArrayList<>();

    private Double balance;
    private Double dailyIncome;
    private Double weeklyIncome;
    private Double monthlyIncome;
}
