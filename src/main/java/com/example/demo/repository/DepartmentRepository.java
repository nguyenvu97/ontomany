package com.example.demo.repository;

import com.example.demo.model.EntityBt.Department;
import com.example.demo.projection.DepartmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String departmentName);

    @Query("SELECT d.name AS departmentName, d.id AS departmentId, COUNT(c.id) AS customerCount  " +
            "FROM Department as d " +
            "LEFT JOIN Customer  as c ON c.department.id = d.id " +
            "WHERE d.id = :id " +
            "GROUP BY  d.id ")
    List<DepartmentDetails> findByDepartmentId(@Param("id") Long departmentId);


}
