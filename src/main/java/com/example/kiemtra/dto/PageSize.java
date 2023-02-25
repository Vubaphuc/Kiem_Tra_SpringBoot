package com.example.kiemtra.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageSize {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPages;
    private Integer totalItems;
    private List<CourseUserDto> data;
}
