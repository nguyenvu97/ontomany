package com.example.demo.Specification;

import com.example.demo.dto.SearchRequestDto;
import com.example.demo.model.EntityBt.Customer;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecs {
    public static Specification<Customer> searchUser(SearchRequestDto searchRequestDto){
            List<Predicate> predicates = new ArrayList<>();
            return (root, query, builder) -> {
                if (searchRequestDto.getUserName() != null && !searchRequestDto.getUserName().isEmpty()){
                    predicates.add(builder.like(root.get("userName"), "%" + searchRequestDto.getUserName()  + "%"));
                }
                if (searchRequestDto.getAddress() != null && !searchRequestDto.getAddress().isEmpty()){
                    predicates.add(builder.equal(root.get("address"), searchRequestDto.getAddress()));
                }

                // Check if predicates list is not empty before using builder.or()
                if (!predicates.isEmpty()) {
                    return builder.or(predicates.toArray(new Predicate[0]));
                } else {
                    // Return a default predicate if predicates list is empty
                    return builder.conjunction(); // or builder.isTrue(builder.literal(true));
                }
            };
        }
}
