package com.appointment.model.dto;

import com.appointment.constant.Jobs;
import com.appointment.model.entity.*;
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
public class BusinessOwnerDto extends PersonDto
{
    private String placeName;
    private String registrationNumber;
    private String businessLicence;
    private String certification;
    private Jobs jobType;
    private Set<CustomerEntity> customers;
    private WorkingTimeEntity workingTimes;
    private Float popularity;
    private List<ReservationEntity> reservationList;
    private List<ServicesEntity> servicesList;
    private List<NotificationEntity> notifications;
    private List<BillEntity> billList = new ArrayList<>();
    private Double dailyIncome;
    private Double weeklyIncome;
    private Double monthlyIncome;
}
