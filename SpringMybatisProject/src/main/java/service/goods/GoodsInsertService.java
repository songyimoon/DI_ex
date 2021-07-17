package service.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.GoodsCommand;
import model.AuthInfoDTO;
import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsInsertService {
	@Autowired
	GoodsRepository goodsRepository;

	public void goodsInsert(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdName(goodsCommand.getProdName());
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdSupplier(goodsCommand.getProdSupplier());
		dto.setRecommend(goodsCommand.getRecommend());

		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());

		String prodImage = "";
		if(!goodsCommand.getProdImage()[0].getOriginalFilename().equals("")) {
			for (MultipartFile mf : goodsCommand.getProdImage()) {
				String original = mf.getOriginalFilename(); // 오리지날이 필요한 이유는 확장자를 알기 위해서임
				String originalExt = original.substring(original.lastIndexOf(".")); // .의 마지막 인덱스부터 가져옴
				String store = UUID.randomUUID().toString().replace("-", "") + originalExt; // -는 없앤다
				// DB에 저장할 파일명을 추출하여 prodImage에 저장
				prodImage += store + ",";
				// 파일을 시스템에 저장
				String filePath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
				File file = new File(filePath + "/" + store);
				// 파일 저장
				try {mf.transferTo(file);} 
				catch (Exception e) {e.printStackTrace();}
			}
			dto.setProdImage(prodImage);

			
		}
		goodsRepository.goodsInsert(dto);
	}
}
