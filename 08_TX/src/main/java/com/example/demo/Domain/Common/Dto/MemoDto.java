package com.example.demo.Domain.Common.Dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MemoDto {
    //ID를 직접 입력할 필요가 없음
//    //ID에 조건 추가
//    @Min(value = 10, message="ID는 10 이상의 값부터 시작합니다.")
//    @Max(value = 65535, message="ID의 최대 숫자는 65535입니다.")
//
//    //ID값이 NULL이면 MESSAGE 띄우기
//    @NotNull(message="ID는 필수 항목입니다.")
    
    
//    private Long id;
//    @NotBlank(message="TEXT를 입력하세요.")
    private String text;
    @NotBlank(message="작성자를 입력하세요.")
    //작성자 양식은 이메일 형태로 
    @Email(message="example@example.com 형식으로 입력하세요")
    private String writer;

//    @NotNull(message="날짜 정보를 선택하세요")
//    @Future(message="오늘날짜기준 이후 날짜를 입력하세요")
//    //    @DateTimeFormat(pattern="yyyy-MM-dd'T' HH:mm") -> 날짜 포매팅 하는 방법
//    private LocalDateTime createAt; //날짜 받기
//    //포매팅을 알아서 해줌
//
//    private LocalDate data_test;
//    //외부에서 입력받는 값은 문자열이고 입력받는 것은 년/월/일인 localdate





}
