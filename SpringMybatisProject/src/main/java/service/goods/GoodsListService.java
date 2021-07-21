package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.GoodsDTO;
import model.StartEndPageDTO;
import repository.GoodsRepository;

public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsList(Model model, Integer page) {
			
		GoodsDTO dto = new GoodsDTO();
		int limit = 5;
		int limitPage = 10;
		
		if(page != null) {
			Long startRow = ((long)page-1)* limit +1;
			Long endRow = startRow + limit - 1;
			
			StartEndPageDTO sep = new StartEndPageDTO();
			sep.setStartRow(startRow);
			sep.setEndRow(endRow);	
			dto.setStartEndPageDTO(sep);
		}
		List<GoodsDTO> list = goodsRepository.goodsList(dto);
		int count = goodsRepository.getGoodsCount();
		model.addAttribute("lists",list);
		model.addAttribute("count",count);
		
		if(page!=null) {
			PageAction pageAction = new PageAction();
			pageAction.page(count, limit, limitPage, page, "goodsList", model);
		}
	}
}
