package com.example.demo.Config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisConfigTest {

    @Autowired
    //Factory도 Bean으로 생성됐는데 그걸 연결해놓음
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void t1(){
        assertNotNull(sqlSessionFactory); //통과 시 SessionFactory bean 객체가
                                          //잘 생성되었음을 의미
        SqlSession sqlSession= sqlSessionFactory.openSession();

        //SqlSession에서 Connection 꺼내오기
        Connection conn = sqlSession.getConnection();
        assertNotNull(conn); //connection객체가 잘 있는지 확인

                //쿼리문을 사용할 수 있게끔 미리 만들어놓은 함수
                //sqlSession안에 있는 여러 함수와 wrapper가 연결되서 실행됨
                // Java wrapper파일안에 Annotation을 넣어서 작업을하면 그 안에 함수를 연결 시켜줌

    }


}