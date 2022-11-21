package com.example.demo.business.dto;


import com.example.demo.annotation.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull(message = "Name must be written")
    private String name;

    @NotNull(message = "Surname must be written")
    private String surname;

    @Size(min = 6,message = "Min: 6")
    private String password;

    @Email
    @UniqueEmail
    @NotNull(message = "Email is not be null.")
    private String email;
}
