package com.example.kiemtra.sercive;


import com.example.kiemtra.database.DataBase;
import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.dto.PageSize;
import com.example.kiemtra.exception.BadRequestException;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.reponsitory.Reponsitory;
import com.example.kiemtra.request.UpsertCourseRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AdminService {
    private final Reponsitory reponsitory;
    static int id = 1;

    public CourseUserDto createCourse(UpsertCourseRequest request) {
        Course course = Course.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .type(request.getType())
                .topics(request.getTopics())
                .thumbnail(request.getThumbnail())
                .userId(request.getUserId())
                .build();
        DataBase.courses.add(course);
        CourseUserDto dto = reponsitory.searchCourseUserDtoByIdCourse(course.getId());
        DataBase.coursesDto.add(dto);
        id++;
        return dto;
    }

    public CourseUserDto searchCoursebyId(Integer id) {
        return reponsitory.searchCourseUserDtoByIdCourse(id);
    }

    public CourseUserDto updateCourses(Integer id, UpsertCourseRequest request) {
        Optional<Course> courseOptional = reponsitory.getUserById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setName(request.getName());
            course.setDescription(request.getDescription());
            course.setType(request.getType());
            course.setTopics(request.getTopics());
            course.setThumbnail(request.getThumbnail());
            course.setUserId(request.getUserId());
            DataBase.courses.add(course);
            CourseUserDto dto = reponsitory.searchCourseUserDtoByIdCourse(course.getId());
            DataBase.coursesDto.add(dto);
            return dto;
        }
        throw new BadRequestException("Not Found Course with id = " + id);

    }

    public void deteleCourse(Integer id) {
        Optional<Course> courseOptional = reponsitory.getUserById(id);
        if (courseOptional.isPresent()) {
            DataBase.courses.removeIf(course -> Objects.equals(course.getId(),id));
        }
        throw new BadRequestException("Not Found Course with id = " + id);
    }

    public PageSize getAllCourse(Integer pageValue, Integer pageSizeValue) {
        return reponsitory.getAllPageSize(pageValue,pageSizeValue);
    }
}
