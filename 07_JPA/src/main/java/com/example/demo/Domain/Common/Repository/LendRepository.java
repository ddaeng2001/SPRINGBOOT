package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Lend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LendRepository extends JpaRepository<Lend, Long> {

    //복잡한 관계형 DB면 MyBatis가 유리하나 기본 테이블 join이라 JPA 사용!
            //SQL 원본 : SELECT * FROM user u INNER JOIN lend l ON u.username=l.username WHERE u.username='user1';
            //JPA에서 전처리 중이기에 관련된 문법을 적용시켜줘야함
                           //lend를 조회하면 book과 user 엔티티가 같이 조회됨 == lend 안에는 user정보가 포함되어있음
                                                //=>username을 조회할 필요가 없음
                                            //l안에는 book, user가 있는데 user를 꺼냄 : l.user(Lend 엔티티 안의 user)
                                                            //l.user.username : lend안에 있는 user의 username이 외부의
    //                                                                          username과 일치하는지
    // lend와 user INNER JOIN
    @Query("SELECT l FROM Lend AS l JOIN FETCH l.user WHERE l.user.username=:username")
    List<Lend> findAllLendsByUser(@Param("username") String username); //유저 정보를 받아서 유저가 대여를 얼마나 하고 있는지
    //리스트형 Lend 반환, 변수명                                          //에 대한 lend 반환


    // 빌려진 책들(Lend) 중에서, 책 이름(bookName)이 주어진 값과 같은 모든 대출 기록(Lend)을 조회하는 쿼리
    @Query("SELECT l FROM Lend AS l JOIN FETCH l.book WHERE l.book.bookName=:bookName")
    List<Lend> findAllLendsByBook(@Param("bookName")String bookName);
}
