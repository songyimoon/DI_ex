package service.goods;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsDeleteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsDel(String prodNum, HttpSession session) {
		GoodsDTO dto = goodsRepository.goodsDetail(prodNum);
		String [] fileNames = dto.getProdImage().split(",");
		String realPath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
		if(fileNames != null && !fileNames[0].equals("")) {
			for(String fileName : fileNames) {
				File file = new File(realPath+"/"+fileName);
				if(file.exists()) {
					file.delete();
				}
			}
		}		
		goodsRepository.goodsDel(prodNum);
	}
}
