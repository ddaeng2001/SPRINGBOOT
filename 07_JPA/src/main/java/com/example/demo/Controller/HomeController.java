package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//단일 경로에 있을 때만 자동으로 import됨


@Controller
@Slf4j
/*applicationcontext라는 영역에 bean 내장 객체 만들어짐 : 사용자 요청 받음*/
public class HomeController {

    @GetMapping("/") //http://localhost:8090/
    /* url에 따라 get 함수 처리*/
    public String home(){
        //System.out.println("GET /"); //로그를 남길 때는 적절하지 않아서 로깅용 함수를 대신할 것임
        log.info("GET /...."); //log 수준에 따라 여러 종류 사용 가능
        return "index"; //index라는 문자열 return
        // /WEB-INF/views/index.jsp
    }
}
