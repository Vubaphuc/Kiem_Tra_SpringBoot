package com.example.kiemtra.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private String  description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;

}
