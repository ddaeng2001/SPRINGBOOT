package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
@Slf4j //로그 남기기 위한 Annotation
public class TxTestService {
    
    //DB내용 삽입
    @Autowired
    private MemoRepository memoRepository;
    
    //TX 처리가 안되는 함수 
    public void addMemo() throws Exception
    {
        log.info("TxTestService's addMemo...");
        Memo memo = Memo.builder()
                        .id(null)
                        .text("tx")
                        .writer("a")
                        .createAt(LocalDateTime.now())
                        .build();
        //insert * 4(쿼리 4번)
        memoRepository.save(memo);
        memo.setId(null);
        memoRepository.save(memo);
        memo.setId(null);
        memoRepository.save(memo);
        memo.setId(null);
        //예외처리 발생
        throw new SQLException();
        //기존에 작업했던 것들이 남아있음 -> TX를 사용하는 r
        //기존의 값들이 쌓여있음

//        memoRepository.save(memo);
    }


                                //SQLException이 발생하면 작업했던 모든 것을 원복시키겠다!
                                //Manager를 2개 사용할 경우 이름 명시가 필수
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager")
    //TX처리를 하는 함수 - 예외가 발생했을 때 값이 table에 삽입되면 안됨
    public void addMemoTx() throws Exception
    {
        log.info("TxTestService's addMemoTx...");
        Memo memo = Memo.builder()
                .id(null)
                .text("tx")
                .writer("a")
                .createAt(LocalDateTime.now())
                .build();
        //insert * 4(쿼리 4번)
        memoRepository.save(memo);
        memo.setId(null);
        memoRepository.save(memo);
        memo.setId(null);
        memoRepository.save(memo);
        memo.setId(null);
        //예외처리 발생
        throw new SQLException();


//        memoRepository.save(memo);
    }
}
