package com.example.kiemtra.controller;


import com.example.kiemtra.database.DataBase;
import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.dto.PageSize;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.model.User;
import com.example.kiemtra.sercive.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    // 1.Xem danh sách tất cả khóa học
    @GetMapping("/courses")
    public List<CourseUserDto> getBlog(@RequestParam(name = "type") String typeValue,
                            @RequestParam(name = "name") String nameValue,
                            @RequestParam(name = "topic") String topicValue) {
        return userService.getAllCourses(typeValue,nameValue,topicValue);
    }


    // 2. Xem thông tin của 1 khóa học cụ thể (thông tin bao gồm thông tin khóa học và nhân viên tư vấn)
    @GetMapping("/courses/{id}")
    public CourseUserDto searchCourseById(@PathVariable Integer id) {
        return userService.searchCourseById(id);
    }
}
