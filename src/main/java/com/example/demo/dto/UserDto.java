package com.example.demo.dto;

import com.example.demo.model.EntityBt.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto  extends Customer {
    public String groupName;
    private String departmentName;
    private String companyName;
}
