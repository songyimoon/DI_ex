package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.PaymentDTO;
import repository.GoodsRepository;

public class DoPaymentService {
	@Autowired
	GoodsRepository goodsRepository;
	public void doPayment(String purchaseNum, String paymentApprPrice, String paymentNumber, Model model) {
		PaymentDTO dto = new PaymentDTO();
//		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
//		String memId = authInfo.getUserId();
//		dto.setMemId(memId);
		dto.setPurchaseNum(purchaseNum);
		dto.setPaymentNumber(paymentNumber);
		dto.setPaymentApprPrice(paymentApprPrice);
		dto.setPaymentMethod("카드");
		goodsRepository.doPayment(dto);
		model.addAttribute("payment",paymentApprPrice);   
	}
}
