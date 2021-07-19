package service.goods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;
import model.CartDTO;
import repository.GoodsRepository;

public class GoodsCartRemoveService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsCartRemove(String prodNums, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId=authInfo.getUserId();
		CartDTO dto = new CartDTO();
		String [] prodNumMap = prodNums.split(","); // mabatis는 in연산자 사용이 가능하다.
		List <String> cs = new ArrayList<String>();
		for(String prodNum : prodNumMap) {
			cs.add(prodNum);
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("prodNums",cs);
		condition.put("memId",memId);
		goodsRepository.goodsCartRemove(condition);
	}
}
