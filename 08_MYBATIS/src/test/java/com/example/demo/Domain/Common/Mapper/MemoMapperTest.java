package com.example.demo.Domain.Common.Mapper;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemoMapperTest {

    @Autowired
    private MemoMapper memoMapper;

    //데이터 삽입
//    @Test
//    public void post1000(){
//        for(int i=1;i<1000;i++){
//            memoMapper.insert(new MemoDto(null,"content-"+i,"writer-"+i,LocalDateTime.now(), null));
//        }
//    }

    //INSERT
    @Test
    public void t1(){

        //업데이트 된 값을 받기 위해 MemoDto 미리 생성
        MemoDto dto = new MemoDto(1L, "내용1", "작성자1", LocalDateTime.now(), null);
        memoMapper.insert(dto);
    }

    //UPDATE
    @Test
    public void t2(){
        MemoDto dto = new MemoDto(1L, "내용1-uPDATE", "작성자1-Update", null, null);
        memoMapper.update(dto);
    }

    //DELETE
    @Test
    public void t3(){
        memoMapper.delete(1L);
    }

    @Test
    public void t4(){
        MemoDto dto = new MemoDto(null, "내용1", "작성자1", LocalDateTime.now(), null);
        memoMapper.insert(dto);
        System.out.println(dto);
    }

    //조회
    @Test
    public void t5(){
//        List<MemoDto> list = memoMapper.selectAll();
//        list.forEach(System.out::println);

        //포함 여부 확인
        List<MemoDto> list = memoMapper.selectAllContains("writer", "2");
        list.forEach(System.out::println);
    }

    @Test
    public void t6(){
        List<Map<String,Object>> list=
        memoMapper.selectAllWithResultMap();
        //리스트여서 stream사용 가능
        list.forEach((map)->{
            System.out.println(map);
        });
    }

    @Test
    public void t7(){
        //Anntoation(단순하면)? Xml(복잡하면)? 선택
        MemoDto dto = new MemoDto(2000L, "내용1", "작성자", LocalDateTime.now(), null);
        memoMapper.insertXML(dto);
    }
}