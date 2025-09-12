package com.example.demo.Domain.Common.Dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MemoDto {

    @NotBlank(message="TEXT를 입력하세요.")
    private String text;
    @NotBlank(message="작성자를 입력하세요.")
    //작성자 양식은 이메일 형태로 
    @Email(message="example@example.com 형식으로 입력하세요")
    private String writer;


}
