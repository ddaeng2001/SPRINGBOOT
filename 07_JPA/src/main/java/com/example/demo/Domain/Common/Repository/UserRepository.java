package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

                                //as u : 별칭 지정
    @Query("SELECT u FROM User as u where u.role=?1")    //u: user 테이블의 앞 글자
                                                    //변수처리 = ?(물음표 순서)
                                                    //해당별칭.조건                                                         //PK의 자료형
    List<User> selectAllByRole(String role);



    //파라미터 2개 받기 - 파라미터 변수는 변수의 순서와 맞게
    @Query("SELECT u FROM User as u where u.role=?1 and u.password=?2")
//                                      ?1(첫번쨰 변수)     ?2(두번째 변수)
    //쿼리문 : SELECT * FROM testdb.user where role='ROLE_USER' and password='1111';
    List<User> selectAllByRoleAndPwd(String role, String password);




    //변수 처리 방식2(많이 사용됨)

                                                    //JPQL에서 사용되는 내부 변수명 :password
    @Query("SELECT u FROM User as u where u.role=:role")
    List<User> selectAllByRole_2(@Param("role") String r);
                                //@Query 에 있는 변수명과 매칭시킬 때 사용되는 Annotation
                                //@Param내의 role이 :role과 매칭되는 것이기에 String 뒤의 파라미터명은
                                //아무렇게나 해도 ㄱㅊ




    //포함 문자열 검색
    //쿼리문 : SELECT * FROM user where username like concat('%', 'user','%');
    @Query("SELECT u From User as u where u.username like concat('%', :user,'%')")
                                                                        //user될지 모르는 변수이기에 : 삽입
    List<User> selectAllLikeUsername(@Param("user")String username);

}
