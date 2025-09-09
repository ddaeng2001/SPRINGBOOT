package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @DisplayName("--기본 CRUD 확인--")
    @Test
    public void t1() {
        //BookRepository에 내용 삽입
        Book book = Book.builder()
                .bookCode(1L)   //code가 id,pk이긴 하지만 자동증가하면 안되기에 제외
                .bookName("JAVA의 정석")
                .publisher("이지퍼블리싱")
                .isbn("2222-1111")
                .build();

        //INSERT
//        bookRepository.save(book);

        //UPDATE
//        bookRepository.save(book);
        //DELETE
//        bookRepository.deleteById(1L); //pk기준으로 삭제
        
        //SELECT
        //단건조회
//        Optional<Book> bookOptional = bookRepository.findById(1L); //단건조회
//        //반환자료형: Optional<Book>
//        Book rBook = null; //null 체크 대신 가능
//        if(bookOptional.isPresent()) //존재 여부에 따라 book을 꺼내올 수 있음
//        {
//            rBook = bookOptional.get();
//            System.out.println(rBook);
//        }

        //SELECTALL - 전체조회 시 페이징 처리 필요
        List<Book> list = bookRepository.findAll();
        list.forEach(System.out::println);



    }

    //ID말고 다른 컬럼들을 조건들로 삼아서 조회를 하려고 할 때

    //BookName
    @DisplayName("--함수명명법 TEST--")
//    @Test
//    public void t2(){
//                                        //BookRepository에서 설정
//        List<Book> list = bookRepository.findByBookName("a");
//        list.forEach(System.out::println);
//
//    }
//
//    //publisher
//    @Test
//    public void t3(){
//        List<Book> list = bookRepository.findByPublisher("a3");
//        list.forEach(System.out::println);
//    }

    //포함 문자열
    @Test void t4(){
        List<Book> list = bookRepository.findByBookNameContains("d");
        list.forEach(System.out::println);
    }

}