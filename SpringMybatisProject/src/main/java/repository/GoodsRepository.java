package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.GoodsDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namepspace = "mappers.goodsMapper";
	String statement;
	
	public String prodNum() {
		statement = namepspace + ".prodNum";
		return sqlSession.selectOne(statement);
	}
	public void goodsInsert(GoodsDTO dto) {
		statement = namepspace + ".goodsInsert";
		sqlSession.insert(statement,dto);
	}
	public List<GoodsDTO> goodsList(){
		statement = namepspace+".goodsList";
		return sqlSession.selectList(statement);
	}
	public GoodsDTO goodsDetail(String prodNum) {
		statement = namepspace + ".goodsDetail";
		return sqlSession.selectOne(statement,prodNum);
	}
	
	public void goodsUpdate(GoodsDTO dto) {
		statement = namepspace + ".goodsUpdate";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
}
