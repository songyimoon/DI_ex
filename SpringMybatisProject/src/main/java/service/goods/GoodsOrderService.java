package service.goods;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.GoodsOrderCommand;
import model.AuthInfoDTO;
import model.CartDTO;
import model.PurchaseDTO;
import repository.GoodsRepository;

public class GoodsOrderService {
	@Autowired
	GoodsRepository goodsRepository;
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {	
		PurchaseDTO dto = new PurchaseDTO();	

		dto.setPurchaseAddr(goodsOrderCommand.getPurchaseAddr());
		dto.setPurchaseMethod(goodsOrderCommand.getPurchaseMethod());
		dto.setPurchaseRequest(goodsOrderCommand.getPurchaseRequest());
		dto.setPurchaseTotPrice(goodsOrderCommand.getPurchaseTotPrice());
		dto.setReceiverName(goodsOrderCommand.getReceiverName());
		dto.setReceiverPhone(goodsOrderCommand.getReceiverPhone());		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchaseNum = df.format(new Date());
		dto.setPurchaseNum(purchaseNum);		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();		
		dto.setMemId(memId);		
		goodsRepository.purchaseInsert(dto);
		
		String [] prodNums = goodsOrderCommand.getProdNums().split(","); // 히든으로 숨겨져있는 상품번호들
		for(String prodNum : prodNums) {
			CartDTO d = new CartDTO();
			d.setPurchaseNum(purchaseNum);
			d.setMemId(memId);
			d.setProdNum(prodNum);
			int i = goodsRepository.purchaseListInsert(d);
			if(i==1) {
				goodsRepository.cartDelete(d);
			}			
		} return purchaseNum; // 변경
	} 
}
