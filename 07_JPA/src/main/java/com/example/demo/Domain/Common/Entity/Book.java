package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //테이블 생성
@Table(name="book")
@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 아규먼트를 받는 생성자
@Builder //빌더 패턴
public class Book {
    @Id //bookCode를 pk로 지정!
    //book이름 지닌 테이블 내 컬럼명 지정
    private Long bookCode;

    //참조변수명과 다른 컬럼명을 지정하고 싶으면(참고) 아래와 같이!
//    @Column(name="bookname") //bookname을 소문자로 지정하고 싶으면

    private String bookName;
    private String publisher;
    private String isbn;
}
