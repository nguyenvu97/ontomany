package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> ,JpaSpecificationExecutor<Person>{

    int countById(long id);

    List<Person> searchByLastName(String lastName);

    List<Person> findTop5ByOrderByLastNameDesc();

    Stream<Person> streamByLastName(String lastName);

}
