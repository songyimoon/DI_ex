package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsCommand;
import service.goods.GoodsNumberService;
import service.goods.GoodsUpdateService;
import service.goods.GoodsDetailService;
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
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.goodsList(model);
		return "goods/goodsList";
	}
	@RequestMapping("goodsRegist")
	public String goodsRegist(Model model) {
		/// Model : 자바에서 만들어진 값을 jsp에 전달할 때 사용
		goodsNumberService.prodNum(model);
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
	
	@RequestMapping("goodsDetail")
	public String goodsDetail(@RequestParam(value = "prodNum") String prodNum, Model model) {
		goodsDetailService.goodsDetail(prodNum, model);
		return "goods/goodsDetail";
	}
	@RequestMapping("goodsModify")
	public String goodsModify(@RequestParam(value = "prodNum") String prodNum, Model model) {
		goodsDetailService.goodsDetail(prodNum, model);
		return "goods/goodsModify";
	}
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand, Errors errors) {
		new GoodsCommandValidator().validate(goodsCommand, errors);
		if(errors.hasErrors()) {			
			return "goods/goodsModify";
		}
		goodsUpdateService.goodsUpdate(goodsCommand);
		return "redirect:/goods/goodsList";
	}
}

