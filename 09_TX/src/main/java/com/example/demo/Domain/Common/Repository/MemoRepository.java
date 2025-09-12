package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Dao와 달리 Insert 코드를 쓰지 않아도 ㄱㅊ!
@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {
                                                    //<엔테티, 엔테티 PK 자료형>
                                        //JpaRepository<Memo,Long>: 기본 crud하는 함수들이 생성됨

    //1.메서드 명명법을 통해 필요한 쿼리 질의하는 방법
    // 메서드를 잘 조합하면 함수 이름을 통해서 쿼리문을 작성하지 않아도 원하는 결과 도출 가능
    //2.JPQL(SQL문 직접)
    //(모듈 시험 후 추후에 다룰 예정)
}
