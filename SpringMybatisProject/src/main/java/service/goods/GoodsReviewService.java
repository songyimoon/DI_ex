package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.GoodsReviewsDTO;
import repository.GoodsRepository;

public class GoodsReviewService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsReviews(String prodNum, Model model) {
		GoodsReviewsDTO dto = goodsRepository.goodsReviews(prodNum);
		model.addAttribute("goodsReviews", dto);
	}
}
