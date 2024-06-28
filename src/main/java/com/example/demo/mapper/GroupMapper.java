package com.example.demo.mapper;

import com.example.demo.dto.GroupDto;
import com.example.demo.model.EntityBt.Group;

public interface GroupMapper {
    GroupDto entityDto(Group group);
    Group dtoEntity(GroupDto groupDto);
}
