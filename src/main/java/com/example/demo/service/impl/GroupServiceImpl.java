package com.example.demo.service.impl;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.model.EntityBt.Company;
import com.example.demo.model.EntityBt.Department;
import com.example.demo.model.EntityBt.Group;
import com.example.demo.model.EntityBt.User;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.CompanyService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.GroupService;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {
    public final GroupRepository groupRepository;
    public final CompanyService companyService;
    public  final DepartmentService departmentService;
    public final UserService  userService;
    private final GroupMapper groupMapper;

    public GroupDto add(GroupDto groupDto) {
        Group group = Group.builder()
                .groupName(groupDto.getGroupName())
                .build();

        List<Company> companies = new ArrayList<>();
        for (CompanyDto companyDto : groupDto.getCompanyDtos()) {
            Company company = Company.builder()
                    .companyName(companyDto.getCompanyName())
                    .group(group)
                    .build();

            List<Department> departments = new ArrayList<>();
            for (DepartmentDto departmentDto : companyDto.getDepartment()) {
                Department department = Department.builder()
                        .name(departmentDto.getName())
                        .company(company)
                        .build();

                List<User> users = new ArrayList<>();
                for (UserDto userDto : departmentDto.getUsers()) {
                    User user = User.builder()
                            .firstname(userDto.getFirstname())
                            .lastname(userDto.getLastname())
                            .address(userDto.getAddress())
                            .userName(userDto.getUserName())
                            .updatedBy("admin")
                            .createdBy("admin")
                            .department(department)
                            .build();

                    users.add(user);
                }
                department.setUsers(users);
                departments.add(department);
            }
            company.setDepartmentList(departments);
            companies.add(company);
        }
        group.setCompanies(companies);

        Group savedGroup = groupRepository.save(group);
        return groupMapper.entityDto(savedGroup);
    }
}
