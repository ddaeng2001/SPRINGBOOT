package com.example.demo.DiTests;

import com.example.demo.Component.PersonComponent;
import com.example.demo.Dto.PersonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest //유닛 테스트를 위한 annotation

public class DiTests {

    @Autowired //클래스의 상단부에 기본적으로 위치
    //의존 주입을 받은 후 작업을 해야하기 때문에
    //Context내에 만들어진 Bean을 외부에서 연결할 때 사용됨
    private PersonComponent personComponent;
    //



    @Test
    public void t1(){
        System.out.println(personComponent);
        //결과 : com.example.demo.Component.PersonComponent@5600a5da
        //--->toString()이 없어서 이렇게 나옴
    }

    @Autowired
    private PersonDto personDto;
    //PersonDto로 만든 Bean이 유일하게 1개라면 이름이 달라도 객체 생성된 Bean에
    //접근 가능하나
    //동일한 클래스로 여러 Bean이 만들어진 경우 반드시 이름으로 구별해야함

    @Test
    public void t2(){
        System.out.println(personDto);
    }

    @Autowired
    private PersonDto person03; //★★이름중요★★
    @Test
    public void t3(){
        System.out.println(person03);
    }

    @Autowired
    private PersonDto personBean;
    @Test
    public void t4(){
        System.out.println(personBean);
    }



    //Application 내에서 꺼내오는 작업
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void t5(){
        System.out.println(applicationContext.getBean("personBean"));
                                            //bean꺼내기작업!
        System.out.println(applicationContext.getBean("person03"));

    }
}
