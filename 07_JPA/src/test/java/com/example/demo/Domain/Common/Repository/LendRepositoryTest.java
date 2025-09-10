package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import com.example.demo.Domain.Common.Entity.Lend;
import com.example.demo.Domain.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
//        User user = userRepository.findById("user1").get(); //NULL체크를 안하고 하는 것
//        Book book = bookRepository.findById(1L).get(); //optional 무시하고 넘어감
//
//        Lend lend = Lend.builder()
//                .id(null) //id무시 - r : id값은 자동증가 설정해놓음
//                .user(user) //어떤 user가 빌렸는지
//                .book(book) //어떤 book을 빌렸는지
//                .build(); //object(객체) 생성
//
//        lendRepository.save(lend); //User와 Book의 PK값이 FK로 저장됨
    }

    @Test
    public void t2(){

//        //user1 bookCode1; 대여
//        User user = userRepository.findById("user1").get();
//        Book book = bookRepository.findById(1L).get();
//
//        1. 빌더 패턴으로 생성
//        Lend lend = Lend.builder()
//                .id(null)
//                .user(user)
//                .book(book)
//                .build();
//
//        2. 기본 생성자 + Setter 메서드로 값 넣기
//        Lend lend = new Lend();
//        lend.setBook(book1);
//        lend.setUser(user1);
//
//        lendRepository.save(lend);

        //user1 bookCode2L 대여
//        User user = userRepository.findById("user1").get();
//        Book book = bookRepository.findById(2L).get();
//        Lend lend = Lend.builder()
//                .id(null)
//                .user(user)
//                .book(book)
//                .build();
//        lendRepository.save(lend);


        //user2 bookCode3L 대여
//        User user = userRepository.findById("user2").get();
//        Book book = bookRepository.findById(3L).get();
//        Lend lend = Lend.builder()
//                .id(null)
//                .user(user)
//                .book(book)
//                .build();
//        lendRepository.save(lend);

        //user3 bookCode4L 대여
        User user = userRepository.findById("user3").get();
        Book book = bookRepository.findById(4L).get();
        Lend lend = Lend.builder()
                .id(null)
                .user(user)
                .book(book)
                .build();
        lendRepository.save(lend);
    }

    @Test
    public void t3(){
//        List<Lend> list = lendRepository.findAllLendsByUser("user1");
//        //user 이름만 넣어주면 대여를 한 도서에 대한 정보를 꺼내옴
//        list.forEach(System.out::println);

        List<Lend> list = lendRepository.findAllLendsByBook("TEST_BOOK");
        list.forEach(System.out::println);
    }

    @Test
    @Transactional(rollbackFor=Exception.class) //LAZY : 데이터 지연을 위해 포함되어야 할 항목
    public void t4(){
        //lend 엔티티 조회 - user,book 엔티티도 함께 딸려나옴
        System.out.println("-------------FETCH TEST START");
        //Hiberate 쿼리문이 언제 동작하는지 확인
        Optional<Lend> lendOptional = lendRepository.findById(5L); //DB에 있는 id 삽입!
        System.out.println("-------------lendRepository.findById() invoke! -------------------");

        //Optional에서 Lend를 꺼내는 작업
        Lend lend = lendOptional.get();
        System.out.println("-------------lendRepository.get() invoke! -------------------");

        //Eager 설정을 하면 getUser()를 하지 않아도 전부 다(book, user) 가져오지만
        // LAZY로 설정한 경우 필요할 때 book이나 user를 꺼내옴!
        User user = lend.getUser(); //point!
        System.out.println(user);
        System.out.println("-------------lend.getUser() invoke! -------------------");

        Book book = lend.getBook();
        System.out.println(book);
        System.out.println("-------------lend.getBook() invoke! -------------------");

        System.out.println("-------------FETCH TEST END");
    }
}