package com.example.demo.service;

import com.example.demo.dto.PageDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.SearchRequestDto;
import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {

    Person add(PersonDto person);

    Person update (PersonDto personDto,long id);

    List<Person> getAll(SearchRequestDto searchRequestDto);

    public PageDto priceGreaterThan(PersonDto personDto);

    int findById(long id);

    List<Person>searchByLastName(String lastName);
    List<Person>top5numberInPerson();
    String streamByLastName(String lastName);
}
