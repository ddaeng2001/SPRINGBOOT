package com.example.demo.Database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void t1() throws SQLException {
        //단위테스트 함수
        assertNotNull(dataSource); //Nullcheck!
        System.out.println(dataSource); //결과 : HikariDataSource (null)

        //DB와 실제 연결된 세션을 얻어 쿼리를 실행하기 위한 준비
        Connection conn = dataSource.getConnection();

        //쿼리문 던질 준비
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setLong(1,1L);
        pstmt.setString(2,"내용내용..");
        pstmt.setString(3, "test@naver.com");
        pstmt.setString(4, LocalDateTime.now().toString());
        int result = pstmt.executeUpdate();
    }

    //java-Config 연결
    @Autowired
    private DataSource dataSource2;

    @Test
    public void test2() throws SQLException {
        //단위테스트 함수
        assertNotNull(dataSource2); //Nullcheck!
        System.out.println(dataSource2); //결과 : HikariDataSource (null)

        Connection conn = dataSource2.getConnection();
        //쿼리문 던질 준비
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setLong(1,2L);
        pstmt.setString(2,"내용내용..");
        pstmt.setString(3, "test2@naver.com");
        pstmt.setString(4, LocalDateTime.now().toString());
        int result = pstmt.executeUpdate();

    }

    @Autowired
    private DataSource dataSource3;
            //상위클래스로 받아내기(업캐스팅)

    @Test
    public void test3() throws SQLException{
        //단위테스트 함수
        assertNotNull(dataSource3); //Nullcheck!
        System.out.println(dataSource3); //결과 : HikariDataSource (null)

        //커넥션 꺼내는 작업
        Connection conn = dataSource3.getConnection();
        //쿼리문 던질 준비
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setLong(1,3L);
        pstmt.setString(2,"내용내용..");
        pstmt.setString(3, "test3@naver.com");
        pstmt.setString(4, LocalDateTime.now().toString());
        int result = pstmt.executeUpdate();

    }

}
