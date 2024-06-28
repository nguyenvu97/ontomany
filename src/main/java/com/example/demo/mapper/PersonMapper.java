package com.example.demo.mapper;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;

public interface PersonMapper {
    PersonDto entityDto(Person person);
    Person dtoEntity(PersonDto personDto);


}
