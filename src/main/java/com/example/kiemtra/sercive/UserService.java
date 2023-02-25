package com.example.kiemtra.sercive;


import com.example.kiemtra.database.DataBase;
import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.reponsitory.Reponsitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final Reponsitory courseReponsitory;



    public CourseUserDto searchCourseById(Integer id) {
        return courseReponsitory.searchCourseUserDtoByIdCourse(id);
    }

    public List<CourseUserDto> getAllCourses(String typeValue, String nameValue, String topicValue) {
        return courseReponsitory.getAllCourses(typeValue,nameValue,topicValue);
    }
}
