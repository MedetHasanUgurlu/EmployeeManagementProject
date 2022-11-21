package com.example.demo.data.entity.concretes;

import com.example.demo.annotation.UniqueEmail;
import com.example.demo.data.entity.abstracts.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter

//LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="employee")
public class EmployeeEntity extends BaseEntity implements Serializable{
    public static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String password;
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


}
