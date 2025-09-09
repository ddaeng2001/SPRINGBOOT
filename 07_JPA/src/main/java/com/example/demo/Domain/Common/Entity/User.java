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
@Table(name="user")
@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 아규먼트를 받는 생성자
@Builder //빌더 패턴
public class User {
    @Id
    @Column(length=100)
    private String username;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 255)
    private String role;
}
