package com.example.demo.model.EntityBt;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<User> users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId",nullable = false)
    private Company company;
}
