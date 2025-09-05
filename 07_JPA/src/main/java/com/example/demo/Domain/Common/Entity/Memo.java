package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity //테이블 생성
@Table(name="memo")
@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 아규먼트를 받는 생성자
@Builder //빌더 패턴
public class Memo {
    //pk지정을 위한 annotation
    @Id
    //각각이 컬럼이 될 예정
    private Long id;
    private String text;
    private String writer;
    private LocalDateTime createAt;
}
