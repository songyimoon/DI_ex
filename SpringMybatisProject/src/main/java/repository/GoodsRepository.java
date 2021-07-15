package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CartDTO;
import model.GoodsDTO;
import model.ProductCartDTO;
import model.PurchaseDTO;

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
	public void goodsDel(String prodNum) {
		statement = namepspace + ".goodsDel";
		int i = sqlSession.delete(statement, prodNum);
		System.out.println(i+"개 행이 삭제되었습니다.");
	}
	public int cartAdd(CartDTO dto) {
		statement = namepspace + ".cartAdd";
		return sqlSession.insert(statement,dto);
	}
	public List<String> memProdNum(String memId) {
		statement = namepspace + ".memProdNum";
		return sqlSession.selectList(statement, memId);
		// 결과값이 2개 이상이니까 (selectList) 사용하는것임
	}
	public ProductCartDTO cartList(CartDTO dto) {
		statement = namepspace + ".cartList";
		return sqlSession.selectOne(statement,dto);
	}
	public void goodsCartQtyDown(CartDTO dto) {
		statement = namepspace + ".goodsCartQtyDown";
		int i = sqlSession.update(statement, dto);
		System.out.println(i+"개 행이 수정되었습니다.");
	}
	public void purchaseInsert(PurchaseDTO dto) {
		statement = namepspace + ".purchaseInsert";
		int i = sqlSession.insert(statement, dto);
		System.out.println(i+"개 행이 저장되었습니다.(purchase)");
	}
	public int purchaseListInsert(CartDTO d) {
		statement = namepspace + ".purchaseListInsert";
		return sqlSession.insert(statement,d);
	}
	public void cartDelete(CartDTO d) {
		statement = namepspace + ".cartDelete";
		sqlSession.delete(statement, d);
	}
}

