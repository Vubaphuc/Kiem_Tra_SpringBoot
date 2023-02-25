package com.example.kiemtra.reponsitory;

import com.example.kiemtra.database.DataBase;
import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.dto.PageSize;
import com.example.kiemtra.exception.BadRequestException;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class Reponsitory {

    public CourseUserDto searchCourseUserDtoByIdCourse (Integer id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Course> courseOptional = DataBase.courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            Optional<User> userOptional = DataBase.users.stream()
                    .filter(user -> course.getUserId().equals(user.getId()))
                    .findFirst();
            User user = userOptional.get();
            CourseUserDto dto = mapper.map(course,CourseUserDto.class);
            mapper.map(user,dto);
            return dto;
        }
        throw new BadRequestException("Not Found Course with id = " + id);
    }

    public Optional<Course> getUserById(Integer id) {
        Optional<Course> courseOptional = DataBase.courses.stream()
                .filter(Course -> Course.getId().equals(id))
                .findFirst();
        return courseOptional;
    }

    public PageSize getAllPageSize(Integer pageValue, Integer pageSizeValue) {
        int totalItems = DataBase.coursesDto.size();
        int totalPages = (int) Math.ceil(totalItems/10);
        PageSize pageSize = new PageSize();
        pageSize.setCurrentPage(pageValue);
        pageSize.setPageSize(pageSizeValue);
        pageSize.setTotalPages(totalPages);
        pageSize.setTotalItems(totalItems);
        pageSize.setData(DataBase.coursesDto);
        // todo chia trang chưa làm được
        return pageSize;
    }

    public List<CourseUserDto> getAllCourses(String typeValue, String nameValue, String topicValue) {
        if (typeValue.equals("") && nameValue.equals("") && topicValue.equals("")) {
            return DataBase.coursesDto;
        }
        List<CourseUserDto> list = new ArrayList<>();
        for (CourseUserDto dto : DataBase.coursesDto) {
            if (dto.getName().equals(nameValue) || dto.getType().equals(typeValue) || dto.getTopics().equals(topicValue)) {
                list.add(dto);
            }
        }
        if (!list.isEmpty()) {
            return list;
        }
        throw new BadRequestException("Không tìm thấy Khóa học nào");
    }
}
