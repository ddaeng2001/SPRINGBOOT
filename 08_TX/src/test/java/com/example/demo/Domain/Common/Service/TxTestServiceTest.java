package com.example.demo.Domain.Common.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TxTestServiceTest {
    @Autowired
    private TxTestService txTestService;

    @Test
    public void t1() throws Exception{
//        txTestService.addMemo();
        txTestService.addMemoTx();
        //SQLException발생 -> rollback 발생으로 값이 테이블 내에 쌓이지 않음
    }
}