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
    public void test2()
    {
        log.info("GET /simple/test2...");
    }


}
