package com.example.kiemtra.controller;


import com.example.kiemtra.dto.CourseUserDto;
import com.example.kiemtra.dto.PageSize;
import com.example.kiemtra.model.Course;
import com.example.kiemtra.request.UpsertCourseRequest;
import com.example.kiemtra.sercive.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    // 1. Xem danh sách khóa học (có phân trang)
    @GetMapping("/courses")
    public PageSize getBlog(@RequestParam(name = "page", defaultValue = "1") Integer pageValue,
                            @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSizeValue) {
        return adminService.getAllCourse(pageValue,pageSizeValue);
    }

    // 2. Tạo khóa học mới
    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseUserDto createCourse(@Valid @RequestBody UpsertCourseRequest request) {
        return adminService.createCourse(request);
    }

    // 3. Lấy chi tiết khóa học
    @GetMapping("/courses/{id}")
    public CourseUserDto searchCoursebyId(@PathVariable Integer id) {
        return adminService.searchCoursebyId(id);
    }

    // 4. Cập nhật thông tin khóa học
    @PutMapping("/courses/{id}")
    public CourseUserDto updateCourses(@Valid @PathVariable Integer id, @RequestBody UpsertCourseRequest request) {
        return adminService.updateCourses(id,request);
    }

    // 5. Xóa khóa học
    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deteleCourse(@PathVariable Integer id) {
        adminService.deteleCourse(id);
    }

}
