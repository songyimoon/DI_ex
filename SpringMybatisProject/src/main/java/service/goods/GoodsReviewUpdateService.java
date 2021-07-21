package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import command.ReviewCommand;
import model.AuthInfoDTO;
import model.ReviewDTO;
import repository.GoodsRepository;

public class GoodsReviewUpdateService {
	@Autowired
	GoodsRepository goodsRepository;
	public void reviewInfo(String purchaseNum, String prodNum, HttpSession session, Model model) {		
		ReviewDTO dto = new ReviewDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setProdNum(prodNum);
		dto.setPurchaseNum(purchaseNum);
		dto = goodsRepository.reviewInfo(dto);
		model.addAttribute("dto",dto);
	}
	
	public void reviewUpdate(ReviewCommand reviewCommand) {
		ReviewDTO dto = new ReviewDTO();
		dto.setProdNum(reviewCommand.getProdNum());
		dto.setPurchaseNum(reviewCommand.getPurchaseNum());
		dto.setReviewContent(reviewCommand.getReviewContent());
		goodsRepository.reviewUpdate(dto);		
	}
}
