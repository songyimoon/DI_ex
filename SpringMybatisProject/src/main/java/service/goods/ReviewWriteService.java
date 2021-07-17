package service.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.ReviewCommand;
import model.AuthInfoDTO;
import model.ReviewDTO;
import repository.GoodsRepository;

public class ReviewWriteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void reviewWrite(ReviewCommand reviewCommand, HttpSession session) {
		ReviewDTO dto = new ReviewDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setProdNum(reviewCommand.getProdNum());
		dto.setPurchaseNum(reviewCommand.getPurchaseNum());
		dto.setReviewContent(reviewCommand.getReviewContent());

		if(!reviewCommand.getReviewImg().getOriginalFilename().isEmpty()) {
			MultipartFile mf = reviewCommand.getReviewImg();
			String original = mf.getOriginalFilename();
			String originalExt = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")+originalExt;
			
			String realPath = session.getServletContext().getRealPath("WEB-INF/view/goods/review");
			File file = new File(realPath + "/" + store);
			try {mf.transferTo(file);} 
			catch (Exception e) {e.printStackTrace();}
			dto.setReviewImg(store);
		}
		goodsRepository.reviewWrite(dto);			
	}
}
