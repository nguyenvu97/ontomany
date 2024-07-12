package com.example.demo.mapper;

public interface MapperTogether<E,D> {
    D  entityDto(E e);
    E dtoEntity(D d);



}
