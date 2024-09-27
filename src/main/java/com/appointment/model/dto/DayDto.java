package com.appointment.model.dto;

import com.appointment.model.Hour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DayDto extends BaseDto
{
    private LocalDate day;
    private List<Hour> hours;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer duration;
}
