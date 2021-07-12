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
}
