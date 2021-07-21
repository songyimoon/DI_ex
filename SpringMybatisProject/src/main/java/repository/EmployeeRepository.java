package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace="mappers.employeeMapper"; //이름은 마음대로 만들어주기
	String statement;
	
	public void empDelete(String empId) {
		statement = namespace + ".empDelete";
		int i = sqlSession.delete(statement,empId);
		System.out.println(i+"개 행이 삭제되었습니다.");
	}
	public void empUpdate(EmployeeDTO dto) {
		statement = namespace + ".empUpdate";
		int i = sqlSession.update(statement, dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
	
	public EmployeeDTO empInfo(String empId) {
		statement = namespace + ".empInfo";
		return sqlSession.selectOne(statement,empId);
	}
	
	public List<EmployeeDTO> empList(EmployeeDTO dto){
		statement = namespace + ".empList";
		return sqlSession.selectList(statement, dto); // selectList > 알아서 List를 만든다. list에 들어갈 제네릭 타입이 뭔지만 알려주기
	}
	public Integer count() {
		statement = namespace + ".count";
		return sqlSession.selectOne(statement);
	}
	
	public void empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i+"개 행이 입력되었습니다.");
	}
	
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
	public EmployeeDTO empMyPageInfo(String empUserId) {
		statement = namespace + ".empMyPageInfo";
		return sqlSession.selectOne(statement,empUserId);
	}
	public void empMyPageInfoModify(EmployeeDTO dto) {
		statement = namespace + ".empMyPageInfoModify";
		int i = sqlSession.update(statement, dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
	public void empPwUpdate(EmployeeDTO dto) {
		statement = namespace + ".empPwUpdate";
		sqlSession.update(statement, dto);
	}
	public void empOutDel(String empUserId) {
		statement = namespace + ".empOutDel";
		int i = sqlSession.delete(statement, empUserId);
		System.out.println(i+"개 행이 삭제되었습니다.");
	}
	
}
