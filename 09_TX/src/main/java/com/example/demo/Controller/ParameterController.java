package com.example.demo.Controller;

import com.example.demo.Dto.PersonDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;


//<파라미터 받기>

@Controller
// view resolver가 찾아주고 있는 상태(동기 방식)
@Slf4j
@RequestMapping("/param")

public class ParameterController {
                                          //요청메서드를 GET으로 함
    @RequestMapping(value="/p01",method= RequestMethod.GET)
    public void paramHandler_1(@RequestParam(name="username", required=false)String name){ //파라미터 요청하는 annotation
                                //폼 요청시의 파라미터들을 @RequestParam으로 다 받을 수 있음
                                //required=false는 파라미터가 필수가 아닐 때
        log.info("GET /param/p01...."+name);
        //http://localhost:8090/p aram/p01?name=%ED%99%8D%EA%B8%B8%EB%8F%99
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
            //Model이라는 객체가 존재하고 의존주입을 받는 중임
            //view로 데이터를 전달할 때 사용됨 : Model
        log.info("GET /param/page1..." + dto);
        //01 파라미터 받기
        //02 유효성 검증
        //03 서비스 실행

        model.addAttribute("dto", dto); //뷰로 키를 통해서 값을 뽑아내올 수 있음
        model.addAttribute("isLogin",true);
        //04 뷰로 이동(자동)
    }



    //{}: path형태
    //요청 URL : localhost:8090/param/page2/홍길동/55/대구
    //path방식으로 던져도 dto내의 속성이 일치하면 자동으로 매핑되어서 파라미터가 받아짐
    @GetMapping("/page2/{name}/{age}/{addr}")
    public ModelAndView page2_handler(PersonDto dto){
        //ModelAndView가 반환하도록 하면 resolved가 알아서 처리
        log.info("GET /param/page2..." + dto);

        //지정한 뷰 경로와 속성값을 전달할 준비
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dto",dto);
        modelAndView.setViewName("param/page2");
        return modelAndView;
    }

    
    
    //Servlet방식으로 파라미터 받기(내장 객체 직접 연결)
    //요청 URL : http://localhost:8090/param/page3?name=홍길동age=55&addr=대구
    @GetMapping("/page3")
                
    public void page3_handler(HttpServletRequest request, HttpServletResponse response){ //response를 적어서 쿠키 값 전달도 가능
        //void는 엔드 포인트를 통해 페이지를 찾음
        String name = request.getParameter("name"); //파라미터 받아주기
        int age =Integer.parseInt(request.getParameter("age")); 
        //쿼리 스트링은 전부 문자열이기에 int를 문자로 형변환 시켜줘야함
        String addr = request.getParameter("addr");
        log.info("GET /param/page3..."+name + " " + age + " " + addr + " ");

        //포워딩해서 세션값에 dto 담기
        PersonDto dto = new PersonDto(name,age,addr);
        request.setAttribute("dto",dto);
        //request의 내용이 그대로 표시된다면 기본적으로 view resolved가 보여주는 방식이 forwarding방식임
//        HttpSession session = request.getSession();
//                //getSession() : 세션 객체 꺼내기
//        session.setAttribute("dto",dto); //ModelAttribute()와 동일

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        
    }

    
    //Collection으로 파라미터 받기
    @GetMapping("/page4")
                                            //value값이 Object로 upcasting돼서 모든 걸 다 받아냄
    public void page4_handler(@RequestParam Map<String,Object> params){ //★Map<String,Object> params : 뭐를 받을지 모를 때 사용됨
                                                                        //but 보통은 Dto를 생성해서 만듦

        log.info("GET /param/page4..." + params); //결과 : {name=홍길동, height=177.7, weight=80.9}
        //http://localhost:8090/param/page4?name=홍길동&height=177.7&weight=80.9

    }
    //--------------------
    //FORWARD( forward: )
    //요청 시 요청된 동기방식이 아닌 원하는 다른 페이지로 내부에서 이동이 가능함
    //이 과정에서 request는 유지가 된 채로 이동됨
    //클라이언트가 1번 요청해도 내부적으로는 몇 번 이동됨
    //--------------------
    //URL : http://localhost:8090/param/forward/init
    //결과값 : /param/forward/step1
              //INIT : init_value
             //STEP1 : step1_value
    @GetMapping("/forward/init")
    public String forward_init_handler(Model model){ //Dispatcher의 연결단위가 Model이라서..?
        log.info("GET /param/forward/init");
        model.addAttribute("init","init_value"); //model에 이 값이 그대로 유지됨

        //step1으로 포워딩하려고 할 때
        //resolve가 알아서 포워딩을 해주기에 키워드 하나만 적어주면 됨
        return "forward:/param/forward/step1"; //step1에서 init값을 확인 가능
    }

    //url : http://localhost:8090/param/forward/step1
    //결과 : /param/forward/step2

    @GetMapping("/forward/step1")
    public String forward_step1_handler(Model model){
        model.addAttribute("step1","step1_value");
        //attribute가 들어가면 view에서는 EL표현식을 통해 key값으로 value값을 꺼내올 수 있음
        log.info("GET /param/forward/step1");

        //step2로 포워딩하려고 할 때
        return "forward:/param/forward/step2";
    }



    @GetMapping("/forward/step2")
    public void forward_step2_handler(){
        log.info("GET /param/forward/step2");
    }



    //--------------------
    //REDIRECT
    //--------------------
    //request는 새로운 내용을 받기 위해 초기화됨

    @GetMapping("/redirect/init")
    public String redirect_init_handler(Model model, RedirectAttributes redirectAttributes){ //Dispatcher의 연결단위가 Model이라서..?
        log.info("GET /param/redirect/init");
        model.addAttribute("init", "init_value");
        //redirect 내용 전달을 위한 Object
        redirectAttributes.addAttribute("r_init","r_init_value");
        //기본적으로 들어가있는 속성은 쿼리(?)스트링으로 전달됨

                            //flashAttribute: 세션 객체에 담아줌(scope 객체)
        redirectAttributes.addFlashAttribute("r_init2", "r_init2_value"); //session 속성 추가(session이 지정한 시간동안 유지됨)
        //step1으로 리다이렉팅
        return "redirect:/param/redirect/step1";
    }


    @GetMapping("/redirect/step1")                                  //->쿼리 스트링(파라미터 형태로)전달되는 것을 받을려면
    public void redirect_step1_handler(Model model, @RequestParam String r_init){
        log.info("GET /param/redirect/step1...r_init" +r_init);
        model.addAttribute("step1", "step1_value");

    }


    @GetMapping("/redirect/step2")
    public void redirect_step2_handler(){
        log.info("GET /param/redirect/step2");
    }


//    @RequestMapping("")
//    public void paramHandler_1(){
//      log.info("");
//    }

}
