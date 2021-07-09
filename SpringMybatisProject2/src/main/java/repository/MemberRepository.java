package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;


import model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers/memberMappers";
	String statement;
	
	public void memJoin(MemberDTO dto) {
		statement = namespace + ".memJoin";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개 행이 저장되었습니다.");
	}
	public List<MemberDTO> memList(String memId){
		statement = namespace + ".memList";
		return sqlSession.selectList(statement,memId);
	}
}
