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

public class GoodsCartListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void cartList(HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		// DTO에 있는 멤버가 1대 1 관계인 경우 mybatis에서는 리스트로 받아오지 못한다.
		
		// ↓ 사용자의 장바구니에 있는 상품번호를 가져옴 
		List <String> prodNums = goodsRepository.memProdNum(memId);
		
		List <ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		for(String prodNum : prodNums) {
			CartDTO dto = new CartDTO();
			dto.setMemId(memId);
			dto.setProdNum(prodNum);
			ProductCartDTO productCartDTO = goodsRepository.cartList(dto);
			list.add(productCartDTO);
		}
		model.addAttribute("lists",list);
	}
}
