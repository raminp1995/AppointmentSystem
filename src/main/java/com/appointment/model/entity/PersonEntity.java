package com.appointment.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class PersonEntity extends BaseEntity
{
    private String fName;
    private String lName;
    private LocalDate birthday;
    private String nCode;
    private String phoneNumber;
    private String Address;
    private Boolean isMale;

    @Column(unique = true, nullable = false)
    private String username;
}
