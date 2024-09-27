package com.appointment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class PersonDto extends BaseDto
{
    private String fName;
    private String lName;
    private LocalDate birthday;
    private String nCode;
    private String phoneNumber;
    private String Address;
    private Boolean isMale;
    private String username;
}
