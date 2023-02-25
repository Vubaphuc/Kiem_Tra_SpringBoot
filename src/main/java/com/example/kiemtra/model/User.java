package com.example.kiemtra.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
