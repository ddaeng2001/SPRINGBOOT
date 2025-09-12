package com.example.demo.Domain.Common.Mapper;


import com.example.demo.Domain.Common.Dto.MemoDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemoMapper {
    //Insert에 사용되는 함수 생성
                                //keyProperty: PK를 지닌 컬럼명
                                //before : insert전/후 실행
                                //result : 반환자료형 결정
    @SelectKey(statement = "SELECT max(id) FROM testdb.tbl_memo;", keyProperty = "id", before = false, resultType = Long.class)
    //키값만 받아오기
    @Insert("insert into tbl_memo values(#{id}, #{text}, #{writer}, #{createAt})")
                                        //#{}: Mybatis용 변수
     public int insert(MemoDto memoDto);    //sqlSession의 insert와 연결됨
            //행의 개수 반환 :int

    //Update
    @Update("update tbl_memo set text=#{text}, writer=#{writer} where id=#{id}")
    public int update(MemoDto memoDto);

    //Delete
    @Delete("delete from tbl_memo where id=#{id}")
    public int delete(Long id);

    //Select
    @Select("select * from tbl_memo")
    public List<MemoDto> selectAll();

    //포함여부 검색
    @Select("select * from tbl_memo where ${type} like concat ('%',#{keyword}, '%')")
    public List<MemoDto> selectAllContains(String type, String keyword);




    //Dto 단위가 아닌 지정한 반환형태로 반환받기
    //반환형태 지정
//    @Results(id="MemoResultMap", value= { //어떤 항목들을 가지고 올지 결정, Dto로 사용하지 못할 수도 있음
//            @Result(property="text", column="content"),
//            @Result(property="writer", column="writer")
//                                //text와 writer에 맞는 클래스를 만들면 여기에 맞는 result를 셋업해줌
//    })

    //커스텀한 반환형태를 받아올 때
    @Select("select text,writer from tbl_memo")
                //하나를 가져오는 단위가 Map
    public List<Map<String,Object>> selectAllWithResultMap();
                //원하는 형태의 컬럼값만 뽑아낼 수 있음 - key:value




    //Xml
    public int insertXML (MemoDto memoDto);
    public int updateXML (MemoDto memoDto);
    public int deleteXML (@Param("id") Long memoId);
}
