package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;
import model.CartDTO;
import repository.GoodsRepository;

public class GoodsCartDeleteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void cartGoodsDel(String prodNum, HttpSession session) { 
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId=authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setMemId(memId);
		dto.setProdNum(prodNum);
		goodsRepository.cartGoodsDel(dto);
	}
}
