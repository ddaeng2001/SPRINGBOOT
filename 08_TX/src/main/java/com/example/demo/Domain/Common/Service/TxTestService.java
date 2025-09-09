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
    private MemoRepository memoRepository; //memoRepository 연결
    
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
        //예외가 발생했음에도 불구하고 테이블에 데이터가 삽입되어있음
        //기존에 작업했던 것들이 남아있음 -> TX를 사용하는 r
        //기존의 값들이 쌓여있음
//        memoRepository.save(memo);

    }



                                                    //Manager(Mybatis, JPA)를 동시에 사용한다고 가정하면 이름 명시가 필수(TxConfig에 있는 매니저 이름 삽입)
    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager")
                  //rollbackFor = 어떤 예외가 발생했을때 다시 rollback할건지 지정 가능
                  //SQLException이 발생하면 작업했던 모든 것을 원복시키겠다!
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
        memo.setId(null); // 새로운 값 삽입을 위해서 필요 == 새로운 엔티티로 인식되기위한 ID초기화
                          // 초기화하지 않으면 ID가 이미 들어가있기 때문에 새로운 내용이 아닌
                          // UPDATE만 지속됨
        memoRepository.save(memo);
        memo.setId(null);
        memoRepository.save(memo);
        memo.setId(null);
        //예외처리 발생
        throw new SQLException();


//        memoRepository.save(memo);
    }
}
