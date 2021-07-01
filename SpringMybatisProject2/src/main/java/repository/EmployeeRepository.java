package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace =  "mappers.employeeMapper";
	String statement;
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
	
	public void empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개 행이 저장되었습니다.");
	}
}
