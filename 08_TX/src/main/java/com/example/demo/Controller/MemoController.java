package com.example.demo.Controller;

import com.example.demo.Domain.Common.Dto.MemoDto;
import com.example.demo.Domain.Common.Service.MemoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

    //MemoDao와 연결하기
    @Autowired
    private MemoService memoService;

    //모든 예외처리
//    @ExceptionHandler(Exception.class)
//    public String exception_handler(Exception e){
//        log.error("MemoController's Exception..." + e);
//        return "memo/error";
//    }

    //직접 관여할 binder 생성 시 databinder에 직접 손댈

    @GetMapping("/add")
    public void add_memo_get() throws Exception{//@Valid MemoDto dto :dto를 가지고 오는데 유효성 검사에 사용하겠다
        log.info("GET /memo/add...");

    }

    @PostMapping("/add")
                                    //바인딩된 결과는 dto에 담겨져있음
    public String add_memo_post(@Valid MemoDto dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws Exception{
                                //유효성 검증            //유효성 검증 결과 담아냄
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
//            throw new Exception("유효성 검증 오류!");

            // 유효성 검증 후 memoService로 이동해서 내용 확인
            // 예외발생 시 memo/add로 이동
              return "memo/add";
        }

        //서비스 요청 -> Domain.Common.Service
//        boolean isAdded = memoservice.memoRegistration(dto);
                                                    //검증이 끝난 dto 전달
//        if(isAdded)
//            redirectAttributes.addFlashAttribute("message","메모등록완료");
//        //메세지를 속성에 넣어주면 EL로 메시지를 뽑아낼 수 있음
//        //문제가 없으면 View로 이동!
//
//        //끝난 후 결과물 뷰로 전달 / 뷰로 이동
//        return (isAdded)?"redirect:/":"memo/add";

        Long insertedId = memoService.memoRegistration2(dto);
        if(insertedId!=null)
            redirectAttributes.addFlashAttribute("message","메모등록완료: "+insertedId);
        //뷰로 이동
        return insertedId!=null?"redirect:/":"memo/add";


    }
}
