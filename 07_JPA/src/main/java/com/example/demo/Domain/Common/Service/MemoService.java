package com.example.demo.Domain.Common.Service;

import com.example.demo.Domain.Common.Dao.MemoDao;
import com.example.demo.Domain.Common.Dto.MemoDto;
import com.example.demo.Domain.Common.Dto.PageDto;
import com.example.demo.Domain.Common.Entity.Memo;
import com.example.demo.Domain.Common.Repository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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

    @Transactional(rollbackFor=Exception.class)
    //MemoRepository
    public Page<Memo> listMemo(PageDto pageDto) throws SQLException {
        //page No를
        //Controller에서 내용을 받아야 함
        //PageBlock : 15개
        int pageNo=0;
        int amount=10; //한페이지에 보여줄 게시물의 건수

        //null이 아니면 삽입, 기본값
        if(pageDto.getPageNo()!=null)
            pageNo = pageDto.getPageNo();
        if(pageDto.getAmount()!=null)
            amount = pageDto.getAmount();

        Pageable pageable = PageRequest.of(pageNo, amount, Sort.by("id").descending());
        Page<Memo> page = memoRepository.findAll(pageable);

        // 페이지 메타 확인
        System.out.println("현재 페이지 번호"+page.getNumber());
        System.out.println("한 페이지에 표시할 건수 : " + page.getSize());
        System.out.println("총 게시물 개수 : " +page.getTotalElements());
        System.out.println("총 페이지 개수 : " + page.getTotalPages());
        System.out.println("첫 번째 페이지인지 여부: " +page.isFirst());
        System.out.println("다음페이지가 있는지 여부 : " +page.hasNext()); //다음 페이지 버튼 활성화
        System.out.println("이전페이지가 있는지 여부 : " +page.hasPrevious()); //이전 페이지 버튼 활성화

        return page;
    }

}
