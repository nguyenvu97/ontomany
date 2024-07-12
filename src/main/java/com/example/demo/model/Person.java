package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Person  implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "firstName",length = 20)
    private String firstName;

    @Column(name = "lastName",length = 20)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameId",nullable = false)
    private Game game;

    @Embedded
    private Address address;



    @Enumerated
    private InfoPerson infoPerson;
    private int age;
    private Date createAt;
    private  Date updateAt;

    @PrePersist
    private void create (){
        createAt = new Date();
        updateAt = new Date();
    }
    @PreUpdate
    private void update (){
        updateAt = new Date();
    }



}
