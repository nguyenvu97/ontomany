package com.example.demo.Specification;



import com.example.demo.dto.PersonDto;
import com.example.demo.dto.SearchRequestDto;
import com.example.demo.model.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonSpecs {
    public static Specification<Person> buildPredicate(SearchRequestDto searchRequestDto) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction(); // Start with an empty conjunction

            if (searchRequestDto.getFirstName() != null && !searchRequestDto.getFirstName().isEmpty()) {
                predicate = builder.and(predicate, builder.like(root.get("firstName" ), "%" +searchRequestDto.getFirstName() + "%"));
            }

            if (searchRequestDto.getLastName() != null && !searchRequestDto.getLastName().isEmpty()) {
                predicate = builder.and(predicate, builder.equal(root.get("lastName"), searchRequestDto.getLastName()));
            }

            return predicate;
        };
    }
    public static Specification<Person> priceGreaterThan(PersonDto searchRequestDto) {
        return new Specification<Person>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (searchRequestDto.getFirstName() != null && !searchRequestDto.getFirstName().isEmpty()){
                    return builder.and(builder.like(root.get("firstName"),"%" +searchRequestDto.getFirstName() + "%"));
                }
                if (searchRequestDto.getLastName() != null && !searchRequestDto.getLastName().isEmpty()){
                    return builder.and(builder.like(root.get("lastName"),"%" +searchRequestDto.getLastName() + "%"));
                }
                if (searchRequestDto.getAge() >0 ){
                    return builder.and(builder.greaterThan(root.get("age"),searchRequestDto.getAge()));
                }
                if (searchRequestDto.getAddress().getCity() != null && !searchRequestDto.getAddress().getCity().isEmpty()){
                    return builder.and(builder.equal(root.get("city"), searchRequestDto.getAddress().getCity()));
                }
                if (searchRequestDto.getInfoPerson().getPhone() != null && !searchRequestDto.getInfoPerson().getPhone().isEmpty() && searchRequestDto.getInfoPerson().getPhone().length() >10){
                    return builder.and(builder.equal(root.get("phone"),searchRequestDto.getInfoPerson().getPhone()));
                }
            return builder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }

    public static Specification<Person>getDataFilter(SearchRequestDto searchRequestDto) {
        List<Predicate> predicates = new ArrayList<>();
        return (root, query, builder) -> {
            if (searchRequestDto.getFirstName() != null && !searchRequestDto.getFirstName().isEmpty()) {
                predicates.add(builder.like(root.get("firstName"), "%" + searchRequestDto.getFirstName() + "%"));
            }
            if (searchRequestDto.getLastName() != null && !searchRequestDto.getLastName().isEmpty()) {
                predicates.add(builder.like(root.get("lastName"), "%" + searchRequestDto.getLastName() + "%"));
            }
            if (searchRequestDto.getAge() > 0) {
                predicates.add(builder.greaterThan(root.get("age"), searchRequestDto.getAge()));
            }
            if (searchRequestDto.getCity() != null && !searchRequestDto.getCity().isEmpty()) {
                predicates.add(builder.equal(root.get("city"), searchRequestDto.getCity()));
            }
            if (searchRequestDto.getPhone() != null && !searchRequestDto.getPhone().isEmpty() && searchRequestDto.getPhone().length() > 10) {
                predicates.add(builder.equal(root.get("phone"), searchRequestDto.getPhone()));
            }
            return  builder.or(predicates.toArray(new Predicate[0]));
        };

    }
}
