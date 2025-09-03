package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Getter
@Setter
@ToString*/
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor
//lombok annotation

@Data
//@Data로 get,set,equals,toString()등을 사용할 수 있음
@Builder
//@Component //ApplicationContext내의 personDto 객체 생성

// f == fields, m == 메서드
public class PersonDto {
    private String name;
    private int age;
    private String addr;

}
