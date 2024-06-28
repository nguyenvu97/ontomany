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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String companyName;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<Department> departmentList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId",nullable = false)
    private Group group;
}
