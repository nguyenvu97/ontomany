package com.example.demo.Specification;

import com.example.demo.dto.UserDto;
import com.example.demo.model.EntityBt.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecs {
    public static Specification<User> searchUser(UserDto userDto){
            List<Predicate> predicates = new ArrayList<>();
            return (root, query, builder) -> {
                if (userDto.getUserName() != null && !userDto.getUserName().isEmpty()){
                    predicates.add(builder.like(root.get("userName"), "%" + userDto.getUserName() + "%"));
                }
                if (userDto.getAddress() != null && !userDto.getAddress().isEmpty()){
                    predicates.add(builder.equal(root.get("address"), userDto.getAddress()));
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
