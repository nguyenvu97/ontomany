package com.example.demo.repository;

import com.example.demo.model.EntityBt.Group;
import com.example.demo.projection.GroupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT " +
            "g.groupName AS groupName, " +
            "g.id AS groupId, " +
            "(SELECT COUNT(c2.id) FROM Company c2 WHERE c2.group.id = g.id) AS companyCount, " +
            "(SELECT COUNT(d.id) FROM Department d WHERE d.company.id IN (SELECT c2.id FROM Company c2 WHERE c2.group.id = g.id)) AS departmentCount, " +
            "(SELECT COUNT(cm.id) FROM Customer cm WHERE cm.department.id IN (SELECT d.id FROM Department d WHERE d.company.id IN (SELECT c2.id FROM Company c2 WHERE c2.group.id = g.id))) AS customerCount " +
            "FROM Group g " +
            "WHERE g.id = :id " +
            "GROUP BY g.id, g.groupName")
    List<GroupDetails> findById(@Param(value = "id") long groupId);


    @Query("SELECT " +
            "g.groupName AS groupName, " +
            "g.id AS groupId, " +
            "COUNT(c.id)  AS companyCount, " +
            "COUNT(d.id)  AS departmentCount, " +
            "COUNT(cm.id) AS customerCount " +
            "FROM" +
            " Group g " +
            "left join Company as c on c.group.id = g.id " +
            "left join Department as d on c.id = d.company.id " +
            "left join Customer as cm on cm.department.id = d.id " +
            "WHERE  " +
            "g.id = :id and c.id =:companyId and  d.id =:departmentId " +
            "GROUP BY g.id , g.groupName"
    )
    GroupDetails findByDetails(@Param(value = "id") long groupId, @Param(value = "companyId") long companyId , @Param(value ="departmentId" ) long departmentId  );
}
