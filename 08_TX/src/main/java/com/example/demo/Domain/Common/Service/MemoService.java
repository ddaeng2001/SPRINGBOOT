package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dao.MemoDao;
import com.example.demo.Domain.Common.Dto.MemoDto;
import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//서비스가 해야 할 작업이 가장 많지만 현재는 할 것이 없어서 간단함
//Bean 생성
@Service
public class MemoService {
    @Autowired
    private MemoDao memoDao; //Memo를 CRUD할 수 있는 Dao와 연결

    //MemoRepository와 연결
    @Autowired
    private MemoRepository memoRepository;

    //판단여부명시
    public boolean memoRegistration(MemoDto dto) throws Exception{ //Controller가 받아낼 예정이라 dto
        int result = memoDao.insert(dto);
        //dao 예외 -> Service -> Controller로 던지기
        
        //insert니까 등록을 정상적으로 한다면 행이 추가되고 추가된 값이 전달될 예정이기 때문에
        return result>0;
    }

    public Long memoRegistration2(MemoDto dto) throws Exception{

        //dto->Entity로 바꾸는 작업 필요
        Memo memo = Memo.builder()
                        .id(null)
                        .text(dto.getText())
                        .writer(dto.getWriter())
                        .createAt(LocalDateTime.now())
                        .build();
        memoRepository.save(memo);
        return memo.getId(); //ID값에 숫자값이 들어올 예정
    }
}
