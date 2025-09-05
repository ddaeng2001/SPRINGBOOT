package com.example.demo.Domain.Common.Dao;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

//Context 영역에 Bean으로 등록시킴
@Repository
public class MemoDao { //MemoDto에 커서 대고 Ctrl+sHift+T하면 단위테스트 자동 생성

    @Autowired
    private DataSource dataSource3; //DataSource를 적절히 꺼내서 CRUD가능

    //Controller가 사용자에게 받은 MemoDto를 삽입예정
    public int insert(MemoDto dto) throws Exception{
        Connection conn = dataSource3.getConnection();
        //쿼리문 던질 준비
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(null,?,?,now())");
        //dto로부터 받은 값 전달
        pstmt.setString(1,dto.getText());
        pstmt.setString(2,dto.getWriter());
        int result = pstmt.executeUpdate();
        //추가된 행의 개수 return
        return result;

    }
}
