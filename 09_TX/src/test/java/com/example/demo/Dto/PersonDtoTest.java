package com.example.demo.Dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonDtoTest {

    @Test
    public void t1(){ //객체 직접생성
        PersonDto dto = new PersonDto("홍길동", 50, "대구");
        System.out.println(dto);
    }

    @Test
    public void t2(){
        //builder패턴이 적용된 객체 생성
        PersonDto dto = PersonDto.builder()
                //순서는 중요하지 않음(여러 순서에 대한 생성자를 만들필요없이 builder가 있으면 원하는 값만 삽입가능)
                //객체하는 시점에서 아래와 같이 만들 수 있게 해줌 by.builder
                .age(20)
                .name("티모")
                .build();
        System.out.println(dto);
    }
}