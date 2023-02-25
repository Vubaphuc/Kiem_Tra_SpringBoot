package com.example.kiemtra.dto;


import com.example.kiemtra.model.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CourseUserDto {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User user;
}
