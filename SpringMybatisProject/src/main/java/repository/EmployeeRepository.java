package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="mappers.employeeMapper"; //이름은 마음대로 만들어주기
	String statement;
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
}
