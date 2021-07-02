package repository;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="mappers.memberMapper";
	String statement;
	
	public void memInsert(MemberDTO dto) {
		statement = namespace + ".memInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개 행이 입력되었습니다.");
	}
}
