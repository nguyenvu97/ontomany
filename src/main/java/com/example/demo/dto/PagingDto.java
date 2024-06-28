package com.example.demo.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data

@SuperBuilder
public class PagingDto {
    private int pageSize;
    private int pageNumber;
}
