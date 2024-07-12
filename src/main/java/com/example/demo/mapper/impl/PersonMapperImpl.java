package com.example.demo.mapper.impl;

import com.example.demo.dto.PersonDto;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Address;
import com.example.demo.model.InfoPerson;
import com.example.demo.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {
    @Override
    public Person dtoEntity(PersonDto personDto) {
            Address address = new Address();
        InfoPerson infoPerson = new InfoPerson();
            BeanUtils.copyProperties(personDto, address);
            BeanUtils.copyProperties(personDto,infoPerson);
            return Person.builder()
                    .address(address)
                    .infoPerson(infoPerson)
                    .firstName(personDto.getFirstName())
                    .lastName(personDto.getLastName())

                    .build();

    }

    @Override
    public PersonDto entityDto(Person person) {
        Address address = new Address();
        InfoPerson infoPerson = new InfoPerson();
        BeanUtils.copyProperties(person, address);
        BeanUtils.copyProperties(person,infoPerson);
        return  PersonDto.builder()
                .address(address)
                .infoPerson(infoPerson)
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .GameName(person.getGame().gameName)
                .age(person.getAge())
                .build();
    }
}
