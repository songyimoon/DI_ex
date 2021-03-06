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
import command.ReviewCommand;
import service.goods.DoPaymentService; 
import service.goods.GoodsBuyService;
import service.goods.GoodsCartAddService;
import service.goods.GoodsCartDeleteService;
import service.goods.GoodsCartListService;
import service.goods.GoodsCartQtyDownService;
import service.goods.GoodsCartRemoveService;
import service.goods.GoodsOrderService;
import service.goods.GoodsReviewUpdateService;
import service.goods.OrderProcessListService;
import service.goods.ReviewWriteService;

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
	@Autowired
	OrderProcessListService orderProcessListService;
	@Autowired
	DoPaymentService doPaymentService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	GoodsReviewUpdateService goodsReviewUpdateService;
	@Autowired
	GoodsCartDeleteService goodsCartDeleteService;
	@Autowired
	GoodsCartRemoveService goodsCartRemoveService;
	
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
	public String goodsBuy(@RequestParam(value = "prodCk") String [] prodNums , HttpSession session, Model model) { // ??????????????? ?????? value??? ???????????????. prodNum??????????????????. ?????? ????????? ??????: session / ?????????????????? ??????:model??????
		goodsBuyService.goodBuy(prodNums, session, model);
		return "goods/order";
	}
	
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {
		// GoodsOrderCommand??? ????????? ?????? ?????? ?????? ???????????? ????????????.
		String purchaseNum = goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purchNo="+purchaseNum+"&payPrice="+goodsOrderCommand.getPurchaseTotPrice();
	}
	@RequestMapping("paymentOk")
	public String paymentOk(@ModelAttribute(value = "purchNo") String purchNo, 
							@ModelAttribute(value = "payPrice") String payPrice) {
		return "goods/payment";
	}
	@RequestMapping("orderProcessList")
	public String orderProcessList(HttpSession session, Model model) {
		orderProcessListService.orderList(session, model);
		return "goods/purchaseCon";
	}
	@RequestMapping(value = "doPayment", method = RequestMethod.POST)
	public String doPayment(@RequestParam(value = "purchaseNum") String purchaseNum,
							@RequestParam(value = "paymentApprPrice") String paymentApprPrice,
							@RequestParam(value = "paymentNumber") String paymentNumber, Model model){
		doPaymentService.doPayment(purchaseNum, paymentApprPrice, paymentNumber, model);
		return "goods/buyFinished";
	}
	@RequestMapping("goodsReview")
	public String goodsReview(@ModelAttribute(value = "purchaseNum") String purchaseNum,
							  @ModelAttribute(value = "prodNum") String prodNum) {
		return "goods/goodsReview";
	}
	@RequestMapping(value = "reviewWrite", method = RequestMethod.POST)
	public String reviewWrite(ReviewCommand reviewCommand, HttpSession session) {
		reviewWriteService.reviewWrite(reviewCommand, session);
		return "redirect:orderProcessList";
	}
	@RequestMapping("goodsReviewUpdate")
	public String reviewUpdate(@ModelAttribute (value = "purchaseNum") String purchaseNum,
			@ModelAttribute (value = "prodNum") String prodNum,
								HttpSession session, Model model) {
		goodsReviewUpdateService.reviewInfo(purchaseNum, prodNum, session, model);
		return "goods/goodsReviewModify";
	}
	@RequestMapping("reviewUpdate")
	public String reviewUpdate(ReviewCommand reviewCommand) {
		goodsReviewUpdateService.reviewUpdate(reviewCommand);
		return "redirect:orderProcessList";
	}
	@RequestMapping("cartGoodsDel")
	public String cartGoodsDel(@RequestParam (value = "prodNum") String prodNum, HttpSession session) {
		goodsCartDeleteService.cartGoodsDel(prodNum, session);
		return "redirect:goodsCartList";
	}
	@RequestMapping("goodsCartRemove")
	public String goodsCartRemove(@RequestParam (value = "prodNums") String prodNums, HttpSession session) {	
		goodsCartRemoveService.goodsCartRemove(prodNums,session);
		return "redirect:goodsCartList";
	}
	
}
