package com.example.demo.Controller.GlobalException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//ControllerAdvice: 관점지향프로그래밍(AOP)이 포함되어있음
//덜 중요하지만 매번 반복해야하는 코드를 (횡단면적 작업)따로 관리하는 방식
//핵심적인 코딩은 따로 관리
//AOP : Proxy(디자인 객체) 대리 객체를 만들어서 처리 ex>Advice, Transaction

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String allExceptionHandler(Exception e){
        log.info("Global Exception Handler...");
        return "global_error";
    }
}
