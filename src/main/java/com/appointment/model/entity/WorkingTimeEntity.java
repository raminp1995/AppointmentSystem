package com.appointment.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "workingTimeTable")
public class WorkingTimeEntity extends BaseEntity
{
    @OneToMany(targetEntity = DayEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DayEntity> days = new ArrayList<>();



    // Get the status of a specific day
//    public List<String> getDayStatus(LocalDateTime date) {
//        for (Day day : days) {
//            if (date.toLocalDate().equals(day.getDayStatus().get(0).getTime().toLocalDate())) {
//                return day.getDayStatus();
//            }
//        }
//        return new ArrayList<>(); // If the day is not found, return an empty list
//    }
}
