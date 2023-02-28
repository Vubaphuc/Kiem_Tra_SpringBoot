package com.example.kiemtra.sercive;


import com.example.kiemtra.database.DataBase;
import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.exception.BadRequestException;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.model.User;
import com.example.kiemtra.reponsitory.Reponsitory;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final Reponsitory reponsitory;



    public CourseUserDto searchCourseById(Integer id) {
        Course course = reponsitory.getCourseByID(id);
        User user = reponsitory.getUserByID(course.getUserId());
        return reponsitory.getCourseUserDto(course,user);
    }


    public List<CourseUserDto> getAllCourses(String typeValue, String nameValue, String topicValue) {
        return reponsitory.getAllCourses(typeValue,nameValue,topicValue);
    }
}
