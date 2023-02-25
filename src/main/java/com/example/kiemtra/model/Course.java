package com.example.kiemtra.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Course {
    private Integer id;
    private String name;
    private String  description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;
}
