package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.GoodsRepository;

// service : 데이터를 DB에 전달하거나 DB로부터 가져온 값을 model에 저장
public class GoodsNumberService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsNum(Model model) { // DB부터 값 가져올 때 모델 필요
		String goodsNum=goodsRepository.goodsNum();
		model.addAttribute("goodsNum",goodsNum);
	}
}
