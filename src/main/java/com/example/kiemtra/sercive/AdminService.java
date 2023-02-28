package com.example.kiemtra.sercive;


import com.example.kiemtra.database.DataBase;
import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.dto.PageSize;
import com.example.kiemtra.exception.BadRequestException;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.model.User;
import com.example.kiemtra.reponsitory.Reponsitory;
import com.example.kiemtra.request.UpsertCourseRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AdminService {
    private final Reponsitory reponsitory;
    static int id = 1;


    public CourseUserDto createCourse(UpsertCourseRequest request) {
        ModelMapper mapper = new ModelMapper();
        Course course = new Course();
        course.setId(id++);
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setType(request.getType());
        course.setTopics(request.getTopics());
        course.setThumbnail(request.getThumbnail());
        course.setUserId(request.getUserId());

        DataBase.courses.add(course);
        User user = reponsitory.getUserByID(course.getUserId());
        CourseUserDto dto = mapper.map(course,CourseUserDto.class);
        dto.setUser(user);

        return dto;
    }




    public CourseUserDto searchCoursebyId(Integer id) {
        Course course = reponsitory.getCourseByID(id);
        User user = reponsitory.getUserByID(course.getUserId());

        return reponsitory.getCourseUserDto(course,user);
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

            User user = reponsitory.getUserByID(course.getUserId());

            return reponsitory.getCourseUserDto(course,user);
        }
        throw new BadRequestException("Not Found Course with id = " + id);

    }

    public void deteleCourse(Integer id) {
        Course course = reponsitory.getCourseByID(id);
        DataBase.courses.removeIf(course1 -> Objects.equals(course.getId(),id));
    }

    public PageSize getAllCourse(Integer pageValue, Integer pageSizeValue) {
        return reponsitory.getAllPageSize(pageValue,pageSizeValue);
    }
}
