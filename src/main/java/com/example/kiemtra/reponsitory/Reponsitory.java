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


    public User getUserByID(Integer id) {
        for (User u : DataBase.users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        throw new BadRequestException("Khong tim thay ID " + id);
    }

    public Course getCourseByID(Integer id) {
        for (Course u : DataBase.courses) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        throw new BadRequestException("Khong tim thay ID " + id);
    }

    public CourseUserDto getCourseUserDto(Course course, User user) {
        ModelMapper mapper = new ModelMapper();
        CourseUserDto dto = mapper.map(course,CourseUserDto.class);
        dto.setUser(user);
        return dto;
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
