package com.example.demo.Controller;

import com.example.demo.Domain.Common.Dto.MemoDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

    //모든 예외처리
//    @ExceptionHandler(Exception.class)
//    public String exception_handler(Exception e){
//        log.error("MemoController's Exception..." + e);
//        return "memo/error";
//    }

    //직접 관여할 binder 생성 시 databinder에 직접 손댈
    @InitBinder
    public void dataBinder(WebDataBinder webDataBinder) throws Exception{
        log.info("MemoController's dataBinder..." + webDataBinder); //먼저 동작
        webDataBinder.registerCustomEditor(LocalDate.class, "data_test", new DataTestEditor());
                      //reflection - 특정 클래스를 받겠다! 변환하려는 타입인 localdate를 삽입
    }
    private static class DataTestEditor extends PropertyEditorSupport {
        //다른 건 알아서 바인딩 하지만 data_test가 들어오면 해당 필드에서 editing해줌
        //문자열로 들어올 때 Editing 처리
        //임의로 property 형변환하는 작업

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            log.info("DataTestEditor's setAsTest text : " + text);
            LocalDate date =null;
            
            if(text.isEmpty()){ //입력된 내용이 없으면

//                date =LocalDate.now(); //현재날짜
            }else{ //내용이 들어왔다면
                //input의 포멧 확인(yyyy#MM#dd)
                text = text.replaceAll("#","-");
                                      //문자열이지만 #이 모두 -로 바뀜
                //date에 연결
                date = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            //변환된 데이터 저장
            setValue(date); //dto에 담아줌
        }
    }

    @GetMapping("/add")
    public void add_memo_get() throws Exception{//@Valid MemoDto dto :dto를 가지고 오는데 유효성 검사에 사용하겠다
        log.info("GET /memo/add...");

    }
    @PostMapping("/add")
                                    //바인딩된 결과는 dto에 담겨져있음
    public void add_memo_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) throws Exception{
        log.info("POST /memo/add..." + dto); //내용 입력 후 메모추가 버튼 클릭 시
        //파라미터

        //입력값검증(데이터 : 값 자체의 순수한 비교 ex>null인가 아닌가?))
        log.info("유효성 오류 발생여부 : " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            //개량 반복문
            for(FieldError error  : bindingResult.getFieldErrors()){
                log.info("Error Field : "+error.getField()+" Error Message : "+error.getDefaultMessage());
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }
//            throw new NullPointerException("예외발생!");
            throw new Exception("유효성 검증 오류!");
        }

        //서비스 요청 -> Domain.Common.Service
        //끝난 후 결과물 뷰로 전달 / 뷰로 이동



    }
}
