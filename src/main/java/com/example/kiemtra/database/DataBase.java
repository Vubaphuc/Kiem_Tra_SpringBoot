package com.example.kiemtra.database;

import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {
    public static List<List<String>> topics = new ArrayList<>();


    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"Nguyễn Văn A","a@Ggmail.com","0912456789",""),
            new User(2,"Nguyễn Văn B","b@Ggmail.com","0912456789",""),
            new User(3,"Nguyễn Văn C","c@Ggmail.com","0912456789",""),
            new User(4,"Nguyễn Văn D","d@Ggmail.com","0912456789",""),
            new User(5,"Nguyễn Văn E","e@Ggmail.com","0912456789","")
    ));
    public static List<CourseUserDto> coursesDto = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();


}
