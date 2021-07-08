package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.GoodsCommand;
import service.goods.GoodsNumberService;
import service.goods.GoodsInsertService;
import service.goods.GoodsListService;
import validator.GoodsCommandValidator;

@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Autowired
	GoodsNumberService goodsNumberService;
	@Autowired
	GoodsInsertService goodsInsertService;
	@Autowired
	GoodsListService goodsListService;
	
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.goodsList(model);
		return "goods/goodsList";
	}
	@RequestMapping("goodsRegist")
	public String goodsRegist(Model model) {
		/// Model : 자바에서 만들어진 값을 jsp에 전달할 때 사용
		goodsNumberService.goodsNum(model);
		return "goods/goodsRegist";
	}
	@RequestMapping(value = "goodsJoin", method = RequestMethod.POST)
	public String goodsJoin(GoodsCommand goodsCommand, Errors errors, HttpSession session ) {
		new GoodsCommandValidator().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			return "goods/goodsRegist";
		}
		goodsInsertService.goodsInsert(goodsCommand,session);
		return "redirect:goodsList";
	}
	
}

