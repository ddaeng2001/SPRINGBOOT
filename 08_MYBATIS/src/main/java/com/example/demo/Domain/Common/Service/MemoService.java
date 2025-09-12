package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dao.MemoDao;
import com.example.demo.Domain.Common.Dto.MemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//서비스가 해야 할 작업이 가장 많지만 현재는 할 것이 없어서 간단함
//Bean 생성
@Service
public class MemoService {
    @Autowired
    private MemoDao memoDao; //Memo를 CRUD할 수 있는 Dao와 연결


    //판단여부명시
    public boolean memoRegistration(MemoDto dto) throws Exception{ //Controller가 받아낼 예정이라 dto
        int result = memoDao.insert(dto);
        //dao 예외 -> Service -> Controller로 던지기
        
        //insert니까 등록을 정상적으로 한다면 행이 추가되고 추가된 값이 전달될 예정이기 때문에
        return result>0;
    }
}
