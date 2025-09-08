package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {
    //매서드명명법
    //JPQL(SQL문직접) -@Query("Select..") 쿼리를 통해서 SQL문 직접 작성 가능
    //Table의 CRUD를 위한 repository
    //JpaRepository를 상속관계로 둠
}
