package repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import command.MemberCommand;
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
	public List<MemberDTO> memList(MemberDTO dto) {
		statement = namespace + ".memList";
		return sqlSession.selectList(statement,dto);
	}
	public void memUpdate(MemberDTO dto) {
		statement = namespace + ".memUpdate";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
	public void memDel(String memId) {
		statement = namespace + ".memDel";
		int i = sqlSession.delete(statement, memId);
		System.out.println(i+"개 행이 삭제되었습니다.");	
	}
	
	public MemberDTO memMypageInfo(String memId) {
		statement = namespace + ".memMypageInfo";
		return sqlSession.selectOne(statement,memId);
	}
	public void memMypageInfoModifyOk(MemberDTO dto) {
		statement = namespace + ".memMypageInfoModifyOk";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
	public void memPwUpdate(MemberDTO dto) {
		statement = namespace + ".memPwUpdate";
		sqlSession.update(statement,dto);
	}
	public int updateCkOk(MemberDTO dto) {
		statement = namespace + ".updateCkOk";
		return sqlSession.update(statement, dto);
	}
	public String idFind(MemberDTO dto) {
		statement = namespace + ".idFind";
		return sqlSession.selectOne(statement,dto);
	}
	public Integer getMemberCount() {
		statement = namespace + ".getMemberCount";
		return sqlSession.selectOne(statement);
	}
}
