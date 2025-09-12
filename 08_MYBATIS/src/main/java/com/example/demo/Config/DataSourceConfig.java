package com.example.demo.Config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//설정Bean 생성
@Configuration
public class DataSourceConfig {

    //Bean 생성
//    @Bean
//    public DataSource dataSource2(){ //dataSource2의 이름을 가진 bean 생성
//        //DataSource 객체 생성
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //드라이버 적재를 위한 작업
//        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
//        dataSource.setUsername("root"); //DB 접속 계정
//        dataSource.setPassword("1234"); //DB 접속 시 사용할 패스워드
//
//        //Connection제어
//        dataSource.setInitialSize(5); //초기 연결 개수
//        dataSource.setMaxTotal(10); //최대 연결 개수
//        dataSource.setMaxIdle(8);   //최대 유휴(일을 하고 있지 않은 상태) 연결 수
//                                    //작업을 하고 있지 않지만 연결되고 있는 수
//        dataSource.setMinIdle(3);   //최소 유휴 연결 수
//
//        //DataSource를 리턴하면 Context영역에 의존성 주입 가능해짐
//        return dataSource;
//    }



    //HikariDataSource 기반
    @Bean
    public HikariDataSource dataSource(){ //dataSource : Bean명
            //HikariDataSource를 기본으로 함
        //DataSource 객체 생성
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //드라이버 적재를 위한 작업
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root"); //DB 접속 계정
        dataSource.setPassword("1234"); //DB 접속 시 사용할 패스워드

        return dataSource;
    }
}
