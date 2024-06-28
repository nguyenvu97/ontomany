package com.example.demo.service.impl;


import com.example.demo.Specification.PersonSpecs;
import com.example.demo.config.ConfigMap;
import com.example.demo.dto.PageDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.SearchRequestDto;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PersonServiceImpl implements PersonService {
    public final PersonRepository personDao;
    public final PersonMapper personMapper;



    @Override
    public Person add(PersonDto  person) {
        Person person1 = personMapper.dtoEntity(person);
        return personDao.save(person1);
    }

    @Override
    public Person update(PersonDto personDto, long id) {
        Person person = personDao.findById(id).orElseThrow(null);
        Address address = new Address();
        address.setZipCode(personDto.getAddress().getZipCode());
        address.setCity(personDto.getAddress().getCity());
        address.setStreet(personDto.getAddress().getStreet());
        address.setZipCode(personDto.getAddress().getZipCode());
        person.setAddress(address);
        return person;
    }



    @Override
    public List<Person> getAll(SearchRequestDto searchRequestDto) {
        Specification<Person> spec =  PersonSpecs.buildPredicate(searchRequestDto);
        return personDao.findAll(spec);
    }

    @Override
    @Lock(LockModeType.READ)
    public PageDto priceGreaterThan(PersonDto personDto) {
        if (personDto.getPageNumber() <= 0 || personDto.getPageSize() <= 0){
            personDto.setPageNumber(ConfigMap.pageNumber);
            personDto.setPageSize(ConfigMap.pageSize);
        }
        Page<Person> page = personDao.findAll(PersonSpecs.priceGreaterThan(personDto),
                PageRequest.of(personDto.getPageNumber(),personDto.getPageSize(),
                Sort.by("email").descending()));

        return (PageDto) PageDto.builder()
                .content(page.getContent()
                        .stream()
                        .map(personMapper::entityDto)
                        .collect(Collectors.toList()))
                .number(page.getNumber())
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
//                .pageNumber(page.getNumber())
//                .pageSize(page.getSize())
                .build();

    }

    @Override
    public int findById(long id) {
        return  personDao.countById(id);
    }

    @Override
    public List<Person> searchByLastName(String lastName) {
        log.info(personDao.searchByLastName(lastName).toString());
        return personDao.searchByLastName(lastName);
    }

    @Override
    public List<Person> top5numberInPerson() {
        return personDao.findTop5ByOrderByLastNameDesc();
    }

    @Override
    public String streamByLastName(String lastName) {
        List<Person> people = new ArrayList<>();
        try (Stream<Person> stream = personDao.streamByLastName(lastName)) {
           stream.forEach(person -> {
               people.add(person);
            });
         return  people.toString();

        }

    }

}
