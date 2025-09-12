package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {

    //특정한 컨트롤러에서만(지역적으로) 예외처리를 하는 방법 or 모든 컨트롤러에 발생하는 예외를 수집하는 방법
    //지역예외처리
//    @ExceptionHandler(FileNotFoundException.class)
//                     //reflection방법 이용
//
//    //FileNotFoundException이 발생했을 때 handler1으로 보냄
//    public String exception_handler1(Exception e, Model model){ //error를 페이지로 보내는 방법1 : Model연결
//        log.error("error: " + e);
//        model.addAttribute("ex",e); //예외객체를 모델에 실어서 보냄
//        return "except/error"; //resolver에 내용 던지기
//    }
//
//    //예외처리 Handler(0으로 나누었을 때 -page2)
//    @ExceptionHandler(ArithmeticException.class)
//    public String exception_hanlder2(Exception e){
//        log.error("error:" + e);
//        return "except/error"; //에러 페이지로 넘기기
//    }
//

    //모든 컨트롤러에 발생하는 예외를 수집하는 방법
//    @ExceptionHandler(Exception.class)
//                     //reflection방법 이용
//
//    public String exception_handler1(Exception e, Model model){
//        log.error("Exception error: " + e);
//        model.addAttribute("ex",e); //예외객체를 모델에 실어서 보냄
//        return "except/error"; //resolver에 내용 던지기
//    }

    //페이지 생성
    @GetMapping("/ex1")
    public void ex1() throws FileNotFoundException{ //프레임워크 내부에서 예외를 받을 예정
        log.info("GET /except/ex1...");
        
        //예외 객체생성
        throw new FileNotFoundException("파일을 찾을 수 없습니다.");
    }


    //페이지2 생성(정상과 비정상 구분하기)
    @GetMapping("/ex2/{num}/{div}")
    public String ex2(
            @PathVariable int num, //경로기반은 마지막({div})을 페이지로 인식해버리기에 String으로 페이지 위치를 잡아줘야함
            @PathVariable int div,
            Model model
    )throws ArithmeticException
    {
        log.info("GET /except/ex2...");
        model.addAttribute("result",(num/div));
        return "except/e2";


    }

    @GetMapping("/ex3")
    public void ex3(){
        log.info("GET /except/ex3...");
    }
}
