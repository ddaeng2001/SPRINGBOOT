package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity //테이블 생성
@Table(name="memo")

//아래 Annotation은 Java에서 쓰기 위한 lombok 설정
@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 아규먼트를 받는 생성자
@Builder //빌더 패턴
public class Memo {
    //pk지정을 위한 annotation
    @Id
    //ID값을 직접 입력할 필요 없이 알아서 내부적으로 INSERT요청을 하면 자동으로 생성해줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //각각이 컬럼이 될 예정
    private Long id;

    //속성추가
    @Column(length=1024)
    private String text;

    //속성추가
    @Column(length=100, nullable = false)
    private String writer;

    private LocalDateTime createAt;
}
