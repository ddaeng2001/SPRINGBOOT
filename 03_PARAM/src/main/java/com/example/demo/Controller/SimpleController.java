package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //ApplicationContext에 사용자 요청을 받는 Bean이 생성됨
@RequestMapping("/simple") //매핑 처리 //기본 경로 설정
                //simple요청에 외부에서
                // 들어오기 위해서는 http:://localhost8090:simple/은 입력해야 들어올 수 있음
@Slf4j //log info

public class SimpleController {

    //외부에서 GET형태의 요청이 들어올 때 받아내는 곳
    @RequestMapping(value = "/test1",method= RequestMethod.GET)
                                            //여러요청을 받아냄
    public void test1()
    {
        log.info("GET /simple/test1...");
    }


    @RequestMapping(value = "/test2",method= RequestMethod.GET)
    //여러요청을 받아냄
    public String test2()

    {
        log.info("GET /simple/test2...");
        //기본적으로 제공하는 위치: /WEB-INF/views/ .jsp
        return "simple/abcd"; //명확하게 어떤 파일을 보여줄 지 알려주기
    }


    //페이지에서 요청하면 기본적으로 GET(문서 요청)
                                            //여러 요청을 받아낼 시 {}로 묶기
    @RequestMapping(value = "/test3",method= {RequestMethod.GET, RequestMethod.POST})
    //여러요청을 받아냄
    public void test3()

    {
        log.info("GET/POST /simple/test3...");
        //기본적으로 제공하는 위치: /WEB-INF/views/ .jsp
    }


}
