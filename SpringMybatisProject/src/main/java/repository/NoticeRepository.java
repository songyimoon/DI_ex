package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.NoticeDTO;

public class NoticeRepository {
	@Autowired
	SqlSession sqlSession;
	String nameSpace = "mappers.noticeMapper";
	String statement;
	
	public String noticeNo() {
		statement = nameSpace + ".noticeNum";
		return sqlSession.selectOne(statement);
	}
	public List<NoticeDTO> noticeList(){
		statement = nameSpace + ".noticeList";
		return sqlSession.selectList(statement);
	}
	public NoticeDTO noticeDetail(String noticeNo) {
		statement = nameSpace + ".noticeDetail";
		return sqlSession.selectOne(statement, noticeNo);
	}
	public void noticeInsert(NoticeDTO dto) {
		statement = nameSpace + ".noticeInsert";
		int i = sqlSession.insert(statement, dto);
		System.out.println(i+"개 행이 입력되었습니다.");
	}
	public void noticeUpdate(NoticeDTO dto) {
		statement = nameSpace + ".noticeUpdate";
		int i = sqlSession.update(statement, dto);
		System.out.println(i+"개 행이 수정되었습니다.");	
	}
	public void noticeReadCount(String noticeNo) {
		statement = nameSpace + ".noticeReadCount";
		sqlSession.update(statement, noticeNo);
	}
	public void noticeDelete(String noticeNo) {
		statement = nameSpace + ".noticeDelete";
		int i = sqlSession.delete(statement, noticeNo);
		System.out.println(i+"개 행이 삭제되었습니다.");
	}
}
