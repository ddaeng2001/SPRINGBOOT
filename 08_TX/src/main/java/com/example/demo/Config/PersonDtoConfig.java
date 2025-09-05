package com.example.demo.Config;

//PersonDtoBean을 여러개 만들어놓고 저장하는 Configuration 파일 생성

import com.example.demo.Dto.PersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDtoConfig {

    @Bean //아래의 코드를 bean으로 만들고 싶을 때 사용
    //ApplicationContext내에 person03이라고 하는 bean이 만들어짐
    //여러 Bean 생성하는 코드 추가
    public PersonDto person03(){
        return PersonDto.builder()
                //필드에 넣으려고 하는 값 추가
                .name("박효신")
                .addr("서울")
                .age(45)
                .build();
    }

    //Bean 이름 지정
    //지정하지 않을 시 기본값은 함수나 클래스명의 소문자
    @Bean(name="personBean")
    //참조변수명은 personBean!!
    public PersonDto person04(){
        return PersonDto.builder()
                //필드에 넣으려고 하는 값 추가
                .name("김범수")
                .addr("울산")
                .age(30)
                .build();
    }
}
