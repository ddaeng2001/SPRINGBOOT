package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    //테스트 사전에 실행할(처리할) 항목 for 테스트
    @BeforeEach
    //메모건수 하나도 없다면(조회되는 게 없다면) memo 엔티티에 1000건을 삽입하겠다!
    public void post1000(){ //1000개를 삽입
        if(memoRepository.count()==0) { //메모건수가 몇 개인지
            for(int i=0;i<1000;i++)
                memoRepository.save(new Memo(null,"TEXT-"+i, "WRITER-"+i, LocalDateTime.now()));

        }
    }
    @Test
    public void t6()
    {
        System.out.println(memoRepository.count());
        //몇 건이 들어갔는지 확인

        //페이징 처리
        //계산할 필요없이 요청하는 설정값 생성
        Pageable pageable = PageRequest.of(0,10); //0번째 페이지 요청 && 페이지 10개
        Page<Memo> page = memoRepository.findAll(pageable);

        // 페이지 메타 확인
        System.out.println("현재 페이지 번호"+page.getNumber());
        System.out.println("한 페이지에 표시할 건수 : " + page.getSize());
        System.out.println("총 게시물 개수 : " +page.getTotalElements());
        System.out.println("총 페이지 개수 : " + page.getTotalPages());
        System.out.println("첫 번째 페이지인지 여부: " +page.isFirst());
        System.out.println("다음페이지가 있는지 여부 : " +page.hasNext()); //다음 페이지 버튼 활성화
        System.out.println("이전페이지가 있는지 여부 : " +page.hasPrevious()); //이전 페이지 버튼 활성화

        //페이지 내의 게시물 정보들 꺼내기 - 실제 데이터 꺼내기
        //10개의 데이터가 100페이지로 나올 예정
        List<Memo> list = page.getContent(); //memo 데이터 확인
        list.forEach(System.out::println);
        //다음페이지 보기
        System.out.println("---");
        Page<Memo> nextPage = memoRepository.findAll(page.nextPageable());
        nextPage.forEach(System.out::println);

        //보통 내림차순으로 해서 데이터를 꺼내옴 -- 정렬을 한 후 데이터를 꺼내오는 작업이 포함되어있음
    }
}