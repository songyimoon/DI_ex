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
	
	public String goodsNum() {
		statement = namepspace + ".goodsNum";
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
	
	
}
