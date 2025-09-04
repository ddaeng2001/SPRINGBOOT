package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//단일 경로에 있을 때만 자동으로 import됨
//동일 클래스가 여러 경로일 경우 잡히지 않음!


@Controller
@Slf4j
/*applicationcontext라는 영역에 bean 내장 객체 만들어짐 : 사용자 요청 받음*/
public class HomeController { //HomeController라는 Bean이 만들어짐

    @GetMapping("/") //Get요청이 들어온 걸 처리하는 URL 지정
    //URL의 경로가 /(최상위 폴더)일 경우
    //아래와 같이 처리하는 함수가 Mapping됨!

    //즉, localhost:8090/을 처리해주는 아래의 함수
    public String home(){
        //System.out.println("GET /"); //로그를 남길 때는 적절하지 않아서 로깅용 함수를 대신할 것임
        log.info("GET /...."); //log 수준에 따라 여러 종류 사용 가능
        return "index";
    }
}
