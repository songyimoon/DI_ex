package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsDetailService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsDetail(String prodNum, Model model) {
		GoodsDTO dto = goodsRepository.goodsDetail(prodNum); 
		model.addAttribute("goodsCommand",dto);
	}
}
