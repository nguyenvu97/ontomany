package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class PageDto extends PagingDto{
    @SuppressWarnings("rawtypes")
    private List content;
    private long totalElements;
    private int number;
    private int numberOfElements;
    private int totalPages;

}
