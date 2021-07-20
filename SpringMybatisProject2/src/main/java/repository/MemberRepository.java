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
	public void memUpdate(MemberDTO dto) {
		statement = namespace + ".memUpdate";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
	public void memDel(String memId) {
		statement = namespace + ".memDel";
		int i = sqlSession.delete(statement,memId);
		System.out.println(i+"개 행이 삭제되었습니다.");
	}
	public MemberDTO memMyPageInfo(String memId) {
		statement = namespace + ".memMyPageInfo";
		return sqlSession.selectOne(statement,memId);
	}
	public void memMyPageInfoUpdate(MemberDTO dto) {
		statement = namespace + ".memMyPageInfoUpdate";
		sqlSession.update(statement, dto);
	}
}
