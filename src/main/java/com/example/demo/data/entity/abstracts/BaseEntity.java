package com.example.demo.data.entity.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

//SuperClass
@MappedSuperclass

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date,updated_date"}, allowGetters = true)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = true)
    private Long id;

    //kim ekledi
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    //kim ne zaman ekledi
    @Column(name = "created_user_date")
    @CreatedDate
    private Date createdDate;

    //kim güncelledi
    @Column(name = "update_by")
    @LastModifiedBy
    private String updateBy;

    //kim ne zaman gucelledi
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;

    //Simdiki zaman verir
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemCreatedDate;
}
