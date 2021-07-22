package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.LibraryDTO;

public class LibraryRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="mappers.libraryMapper";
	String statement;

	public void libJoin(LibraryDTO dto) {
		statement = namespace + ".libJoin";
		sqlSession.insert(statement,dto);
	}
	public List<LibraryDTO> libList(){
		statement = namespace + ".libList";
		return sqlSession.selectList(statement);
	}
	public LibraryDTO libraryInfo(String noticeNo) {
		statement = namespace + ".libraryInfo";
		return sqlSession.selectOne(statement, noticeNo);
	}
	public void libCount(String noticeNo) {
		statement = namespace + ".libCount";
		sqlSession.update(statement, noticeNo);
	}
	public void libModify(LibraryDTO dto) {
		statement = namespace + ".libModify";
		sqlSession.update(statement, dto);
	}
	public void libDel(String noticeNo) {
		statement = namespace + ".libDel";
		sqlSession.delete(statement, noticeNo);
	}
}

