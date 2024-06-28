package com.example.demo.model.EntityBt;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String userName;
    private String lastname;
    private String address;
    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId",nullable = false)

    private Department department;


    @PrePersist
    private void create (){
        createdTime = new Date();
        updatedTime = new Date();
    }
    @PreUpdate
    private void update (){
        updatedTime = new Date();
    }
}

