package com.example.demo.Controller;

import com.example.demo.Dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/param")

public class ParameterController {
                                          //요청메서드를 GET으로 함
    @RequestMapping(value="/p01",method= RequestMethod.GET)
    public void paramHandler_1(@RequestParam(name="username", required=false)String name){ //파라미터 요청하는 annotation
                                //폼 요청시의 파라미터들을 @RequestParam으로 다 받을 수 있음
                                //required=false는 파라미터가 필요 없을 때
        log.info("GET /param/p01...."+name);
        //http://localhost:8090/param/p01?name=%ED%99%8D%EA%B8%B8%EB%8F%99
    }
    @GetMapping("/p02") //GET만 받아낼 수 있는 Annotation
    public void paramHandler_2(@RequestParam(name="username", required=true)String name){
        log.info("GET /param/p02..." +name);

    }

    @PostMapping("/p03") //GET만 받아낼 수 있는 Annotation
    public void paramHandler_3(@RequestParam(name="username", required=true)String name){
        log.info("POST /param/p03..." +name);

    }

    //<파라미터를 받을 때 사용>
    //@RequestParam[기본] : 동기요청 파라미터 처리 / html form 기반 전달되는 파라미터 처리(JS의 form-data도 받기 가능, JSON Type 받기 불가)
    //@RequestBody        : 비동기요청 파라미터 처리 / json, filedata등 전달되는 파라미터 처리(html form처리 가능)
                                            //json : 받아내긴 하나 json타입 그대로 받아냄
                                            //
    @PostMapping("/p04") //GET만 받아낼 수 있는 Annotation
    public void paramHandler_4(@RequestBody String name){
        log.info("POST /param/p04..." +name);

    }
    //filedata, json을 받아낼 때는  RequestBody 나머지는 RequestParam!

    //기본값 설정가능
    @PostMapping("/p05") //GET만 받아낼 수 있는 Annotation
    public void paramHandler_5(@RequestParam(name="username", required=false,defaultValue = "홍길동")String name){
                                                                //파라미터를 전달하지 않더라도 기본적으로 들어가는 파라미터 값 지정 가능(defaultValue)
        log.info("POST /param/p05..." +name);


    }
    
    //파라미터 여러 개 받기
    @GetMapping("/p06")
    public void paramHandler_6(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String addr

    ){
        log.info("GET /param/p06..." +name+" "+age+" "+addr);

    }

    //여러 개 받을 단위를 클래스로 묶어서 파라미터에 연결해주면 이름, 나이, 주소를 받아낼 수 있음
    //GET : 쿼리(?)로 파라미터 받을 예정
    @GetMapping("/p07")
    public void paramHandler_7(@ModelAttribute PersonDto dto){
                                //@ModelAttribute는 기본값이라 생략해도 ㄱㅊ!
        log.info("GET /param/p07..."+dto) ;
    }

    //경로 기반의 파라미터 전송 방식
    @GetMapping("/p08/{name}/{age}/{addr}")
                     //순서대로 경로값을 넣어서 {}로 매핑시켜야함
                     //이런식으로 많이 스프링부트에서 사용됨
    public void paramHandler_8(
            @PathVariable(value="name") String username,
                         //username과 mapping되는 path는 name임을 명시 - {name}과 String username의 변수명이 다르기에
            @PathVariable int age,
            @PathVariable String addr
            //http://localhost:8090/param/p08/홍길동/55/대구
            //->파라미터인지 아닌지 경로를 헷갈리게 하는 용도

    ){
        log.info("GET /param/p08..." +username+" "+age+" "+addr);

    }

    //HTTP 요청 파라미터(경로 변수의 이름)과 DTO 필드명일 일치할 경우 가능!
    //자동으로 값 바인딩해줌
    @GetMapping("/p09/{name}/{age}/{addr}")
    public void paramHandler_9(PersonDto dto){
        log.info("GET /param/p09..." +dto);

    }


    //http://localhost:8090/param/page1?name=홍길동&age=55&addr=대구
    //localhost:8090/param/page1을 요청하면 /WEB-INF/views/param/page1.jsp를 전달해서 연결해줌
    @GetMapping("/page1")
    public void page1(PersonDto dto, Model model){ //파라미터를 외부로부터 받은것 : PersonDto dto
                    //view로 데이터를 전달할 때 사용됨 : Model
        log.info("GET /param/page1..." + dto);
        //01 파라미터 받기
        //02 유효성 검증
        //03 서비스 실행

        model.addAttribute("dto", dto); //뷰로 키를 통해서 값을 뽑아내올 수 있음
        model.addAttribute("isLogin",true);
        //04 뷰로 이동(자동)
    }
        





//    @RequestMapping("")
//    public void paramHandler_1(){
//      log.info("");
//    }

}
