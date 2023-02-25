package com.example.kiemtra.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UpsertCourseRequest {
    @NotEmpty(message = "Không được để trống")
    private String name;
    @NotEmpty(message = "Không được để trống")
    @Size(min = 51, message = "Chuỗi phải có độ dài lớn hơn 50 ký tự")
    private String description;
    @NotEmpty(message = "Không được để trống")
    private String type;
    private List<String> topics;
    private String thumbnail;
    @NotEmpty(message = "Không được để trống")
    private Integer userId;
}
