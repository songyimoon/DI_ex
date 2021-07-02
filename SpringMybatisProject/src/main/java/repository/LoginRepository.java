package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;

public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.LoginMapper"; // mapper.xml에 있는 namespace랑 똑같으면 된다. 파일명은 중요X
	String statement;
	public AuthInfoDTO login(String userId) {
		statement = namespace + ".login";
		return sqlSession.selectOne(statement, userId);
	}
}
