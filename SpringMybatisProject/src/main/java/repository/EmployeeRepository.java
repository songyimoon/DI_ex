package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="mappers.employeeMapper"; //이름은 마음대로 만들어주기
	String statement;
	
	
	public void empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개 행이 입력되었습니다.");
	}
	
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}

	
}
