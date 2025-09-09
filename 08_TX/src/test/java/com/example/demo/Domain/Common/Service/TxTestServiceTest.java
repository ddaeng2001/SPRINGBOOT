package com.example.demo.Domain.Common.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TxTestServiceTest {
    //Service영역은 비지니스영역이라서 코드라인이 길어질 가능성 높음
    @Autowired
    private TxTestService txTestService;

    @Test
    public void t1() throws Exception{
//        txTestService.addMemo();
        txTestService.addMemoTx();
        //addMemoTx()는 트랜잭션이 설정되어있기에
        //SQLException발생 -> rollback 발생으로 값이 테이블 내에 쌓이지 않음
    }
}