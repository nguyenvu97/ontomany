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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String firstName;
    @NonNull
    private String userName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_Id",nullable = false)
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

