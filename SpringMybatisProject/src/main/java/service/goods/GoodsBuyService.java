package service.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.CartDTO;
import model.ProductCartDTO;
import repository.GoodsRepository;

public class GoodsBuyService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodBuy(String [] prodNums, HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		List <ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		for(String prodNum : prodNums) {
			CartDTO dto = new CartDTO();
			dto.setMemId(memId);
			dto.setProdNum(prodNum);
			// 카트리스트에서 사용한 정보가 구매페이지에서도 똑같이 사용되므로, 해당 코드를 그대로 적용한다.
			ProductCartDTO productCartDTO = goodsRepository.cartList(dto);
			list.add(productCartDTO);
		}
		model.addAttribute("lists", list);
	}
}
