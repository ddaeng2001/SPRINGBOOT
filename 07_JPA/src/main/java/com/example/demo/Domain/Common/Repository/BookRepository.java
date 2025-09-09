package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
                                                    //<엔티티명, 엔티티의 pk명>
                                        //CRUD를 알아서 구현해줌

  //[기본]
 //bookRepository.findById(1L)
//쿼리문 : select * from book where bookCode=?

                //이름에 대한 규칙을 잘 지켰다면 hiberate가 내부적으로 알아서 잘 구현해줌
    List<Book> findByBookName(String bookName);
    //쿼리문 : select * from book where bookName =?

    List<Book> findByPublisher(String publisher);
    Book findByIsbn(String isbn);
            //Isbn은 보통 유일한 값을 지니기에 단건 조회로 해도 가능!
    List<Book> findByBookNameAndPublisher(String bookName, String publisher);
    // 규칙을 잘못 지정하면 실행과정에서 오류가 발생함
    
    //포함 문자열
                                            //파라미터명은 다양하게 가능
    List<Book> findByBookNameContains(String bookName);
    //쿼리문 : select * from memo where bookName like '%?%'(~를 포함하는)
}
