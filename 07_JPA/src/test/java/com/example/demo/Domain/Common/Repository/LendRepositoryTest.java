package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import com.example.demo.Domain.Common.Entity.Lend;
import com.example.demo.Domain.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LendRepositoryTest {
    @Autowired
    private LendRepository lendRepository;

    //LendRepository뿐만 아니라 이와 연관된 Repository들을 다 연결시켜줘야 함
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void t1(){
        //SELECT ALL
//        List<Lend> list = lendRepository.findAll();   //반환자료형 : List<Lend>
//        list.forEach(System.out::println);

        //INSERT
        User user = userRepository.findById("user1").get(); //NULL체크를 안하고 하는 것
        Book book = bookRepository.findById(1L).get(); //optional 무시하고 넘어감
        
        Lend lend = Lend.builder()
                .id(null) //id무시 - r : id값은 자동증가 설정해놓음
                .user(user) //어떤 user가 빌렸는지
                .book(book) //어떤 book을 빌렸는지
                .build(); //object(객체) 생성
        
        lendRepository.save(lend); //User와 Book의 PK값이 FK로 저장됨
    }
}