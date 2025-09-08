package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dto.MemoDto;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

//결합도를 낮추기 위한 인터페이스 생성 - 중간에 공정 하나를 더 추가
//작업이 끝나고 인터페이스를 빼면 됨
public interface MemoService {
    boolean memoRegistration(MemoDto dto) throws Exception;

    @Transactional(rollbackFor = SQLException.class, transactionManager = "jpaTransactionManager")
    Long memoRegistration2(MemoDto dto) throws Exception;
}
