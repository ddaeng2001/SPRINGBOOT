package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //테이블 생성
@Table(name="lend")
@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 아규먼트를 받는 생성자
@Builder //빌더 패턴
public class Lend {
    
    //들어갈 Column명
    @Id
    //값이 들어오면 ID값이 자동증가되도록 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID를 지정하고 싶다면 이부분을 주석 처리
    private Long id;

    
    //User 테이블과 매핑
    //★★ : 테이블과 매핑되는 부분
    @ManyToOne(fetch =FetchType.LAZY)
    //관계매핑(Many : 다 To: 대 One: 일)
    //어떤 컬럼과 연결할지 지정할 때 사용하는 Annotation
    @JoinColumn(
            //Option 삽입
            name="username",    //외래키 컬럼명
            foreignKey=@ForeignKey(//외래키 설정 시 사용되는 Annotation
                    name="FK_LEND_USER",

                    //외래키 관련 코드
                    foreignKeyDefinition = "FOREIGN KEY (username) REFERENCES user(username) ON DELETE CASCADE ON UPDATE CASCADE"
                                            // FOREIGN KEY (username) REFERENCES testdb.user (username) ON DELETE CASCADE ON UPDATE CASCADE
            )
    )
    //첫번째 컬럼은 User Entity에서 뽑아오기(연결)
    private User user;


    
    //Book 테이블과 매핑
    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(
            name="bookCode", //foreignKeyDefinition에 들어갈 bookCode와 이름명이 같아야함
            foreignKey = @ForeignKey(
                    name="FK_LEND_BOOK",
                    foreignKeyDefinition = "FOREIGN KEY (bookCode) REFERENCES book(bookCode) ON DELETE CASCADE ON UPDATE CASCADE"
            )
    )
    //Book Entity와 연결
    private Book book;

}
