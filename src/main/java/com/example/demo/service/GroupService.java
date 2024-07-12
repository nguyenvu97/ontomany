package com.example.demo.service;

import com.example.demo.dto.GroupDto;
import com.example.demo.projection.GroupDetails;

import java.util.List;

public interface GroupService {
    GroupDto add (GroupDto group);
    List<GroupDetails> fingbyId(long id);
    GroupDetails findByDetails(long id , long companyId , long departmentId );
}
