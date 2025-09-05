//package com.example.demo.Domain.Common.Service;
//
//import com.example.demo.Domain.Common.Dto.MemoDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//@SpringBootTest
//class MemoServiceTest {
//
//    @Autowired
//    //메모 서비스 연결
//    private MemoService memoService;
//
//    @Test
//    public void t1() throws Exception{
//        MemoDto dto = new MemoDto(11L,"","a@a.com", LocalDateTime.now(),null);
//        memoService.memoRegistration(dto);
//
//    }
//}