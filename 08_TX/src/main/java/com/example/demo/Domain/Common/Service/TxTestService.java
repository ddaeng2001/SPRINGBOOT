package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }
    
    //TX처리를 하는 함수
    public void addMemoTx() throws Exception
    {
        log.info("TxTestService's addMemoTx...");
    }
}
