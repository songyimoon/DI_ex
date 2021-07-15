package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsOrderCommand;
import service.goods.GoodsBuyService;
import service.goods.GoodsCartAddService;
import service.goods.GoodsCartListService;
import service.goods.GoodsCartQtyDownService;
import service.goods.GoodsOrderService;

@Controller
@RequestMapping("cart")
public class GoodsCartController {
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@Autowired
	GoodsCartListService goodsCartListService;
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@Autowired
	GoodsOrderService goodsOrderService;
	
	@RequestMapping(value = "goodsCartAdd", method = RequestMethod.POST)
	public String goodsCartAdd(@RequestParam (value = "cartQty") int cartQty, 
								@RequestParam(value = "prodNum") String prodNum,
								@RequestParam(value = "prodPrice") int prodPrice,
								Model model, HttpSession session) {
		goodsCartAddService.cartAdd(cartQty, prodNum, prodPrice, session, model);
		return "goods/cartAdd";
	}
	@RequestMapping(value = "goodsCartAdd", method = RequestMethod.GET)
	public String goodsQtyAdd(@RequestParam (value = "cartQty") int cartQty, 
								@RequestParam(value = "prodNum") String prodNum,
								@RequestParam(value = "prodPrice") int prodPrice,
			Model model, HttpSession session) {
		goodsCartAddService.cartAdd(cartQty, prodNum, prodPrice, session, model);
		return "redirect:goodsCartList";
	}
	
	@RequestMapping("goodsCartList")
	public String goodsCartList(HttpSession session, Model model) {
		goodsCartListService.cartList(session, model);
		return "goods/goodsCart";
	}
	@RequestMapping(value = "goodsCartQtyDown", method = RequestMethod.GET)
	public String goodsCartQtyDown(@RequestParam(value = "prodNum") String prodNum,
									@RequestParam(value = "prodPrice") int prodPrice, HttpSession session) {
		goodsCartQtyDownService.goodsCartQtyDown(prodNum, prodPrice, session);
		return "redirect:goodsCartList";
	}
	@RequestMapping(value = "goodsBuy", method = RequestMethod.POST)
	public String goodsBuy(@RequestParam(value = "prodCk") String [] prodNums , HttpSession session, Model model) { // 체크박스에 있는 value가 상품번호임. prodNum받아오는것임. 누가 사는지 확인: session / 구매페이지에 전달:model필요
		goodsBuyService.goodBuy(prodNums, session, model);
		return "goods/order";
	}
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {
		// GoodsOrderCommand가 가지고 있는 값을 구매 테이블에 전달하자.
		String purchaseNum = goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purchNo="+purchaseNum+"&payPrice="+goodsOrderCommand.getPurchaseTotPrice();
	}
	@RequestMapping("paymentOk")
	public String paymentOk(@ModelAttribute(value = "purchNo") String purchNo, 
							@ModelAttribute(value = "payPrice") String payPrice) {
		return "goods/payment";
	}
	
	
	
	
	
	
}
