package com.appointment.model.entity;

import com.appointment.model.Hour;
import com.appointment.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class DayEntity extends BaseEntity
{
    private LocalDate day;
    @OneToMany(targetEntity = Hour.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Hour> hours = new ArrayList<>(); // List of hours (with LocalDateTime)
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer duration;





        // UnReserve a specific hour
        public boolean unReserveHour (LocalTime time){
        for (Hour hour : hours)
        {
            if (hour.getTime().equals(time))
            {
                hour.unReserve();
                return true;
            }
        }
        return false; // Return false if the time was not found
    }

        // Check if a specific hour is reserved
        public boolean isHourReserved (LocalTime time){
        for (Hour hour : hours)
        {
            if (hour.getTime().equals(time))
            {
                return hour.isReserved();
            }
        }
        return false;
    }

        // Get the status of all hours in the day
        public List<String> getDayStatus () {
        List<String> status = new ArrayList<>();
        for (Hour hour : hours)
        {
            status.add(STR."\{hour.getTime()} -> \{hour.isReserved() ? "Busy" : "Free"}");
        }
        return status;
    }
}
