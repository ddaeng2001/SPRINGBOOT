package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemoRepositoryTest {
    //구현체가 구현을 다 만들어놓음(JPA 사용 이유)
    @Autowired
    private MemoRepository memoRepository;

    //내용삽입(Insert)
    @Test
    public void t1(){
        Memo memo = new Memo(null, "내용1", "test@test.com", LocalDateTime.now());
                                //AI기능 때문에 ID는 자동으로 증가!
        memoRepository.save(memo); //save==insert
                                    //insert된 pk값을 memo 엔터티???
        System.out.println("ID: " + memo.getId()); //새로 추가된 ID확인 가능! //Insert 후 Select 가능!

    }

    //내용 수정(Update)
    @Test
    public void t2(){
        Memo memo = new Memo(1L, "수정된 내용", "test@test.com", LocalDateTime.now());
        //가지고 있는
        memoRepository.save(memo); //save == insert == update
        //insert된 pk값을 memo 엔터티
        System.out.println("ID: " + memo.getId());

    }

    @Test
    //삭제(Delete)
    public void t3(){
        memoRepository.deleteById(1L); //PK기준으로 삭제
    }

    //단건 조회
    @Test
    public void t4(){
        Optional<Memo> memoOptional = memoRepository.findById(1L);
        //반환자료형 : Optional<Memo> - 조회결과물이 Null인지 아닌지를 대신 해줌
        if(memoOptional.isPresent()){
            Memo memo = memoOptional.get();
            System.out.println(memo);
        }
    }

    //전체 조회
    @Test
    public void t5(){
        List<Memo> list = memoRepository.findAll(); //반환자료형 List<Memo>
        list.forEach(System.out::println); //forEach(()->{}) 축약형으로 하나씩 꺼내서 볼 수 있음!
    }
}