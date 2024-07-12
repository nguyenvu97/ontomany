package com.example.demo.repository;

import com.example.demo.model.EntityBt.Customer;
import com.example.demo.projection.UserDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    @Query("select u.id as userId, u.userName as username, d.name as departmentName, c.companyName as companyName " +
            "from Customer u " +
            "left join Department d on d.id = u.department.Id " +
            "left join Company c on c.id = d.company.Id " +
            "left join Group g on g.id = c.group.Id " +
            "where u.id = :id")
    UserDetailProjection findByID(@Param("id") long id);

}
