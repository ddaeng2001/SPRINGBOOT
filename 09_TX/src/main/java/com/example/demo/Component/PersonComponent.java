package com.example.demo.Component;

import lombok.Data;
import org.springframework.stereotype.Component;


//personComponent라는 bean객체가 ApplicationContext내에 생성됨
//bean이름을 명시하지 않으면 지정되어있는 클래스명의 소문자를 따서 만듦
//중요!! - r : 여러 개의 bean을 만들고 싶을 때 bean이름을 잘못 지정하면 위치
//를 알 수가 없음

@Component
@Data //lombock annotation은 getter/setter/을 자동으로 넣어줌
public class PersonComponent {
    private String name;
    private int age;
    private String addr;

    //디폴트 생성자 - 초기값 설정
    PersonComponent(){
        this.name="홍길동";
        this.age = 50;
        this.addr="대구";
    }
}
