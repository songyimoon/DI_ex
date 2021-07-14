package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.GoodsCommand;
import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsUpdateService {
	@Autowired
	GoodsRepository goodsRepository;

	public void goodsUpdate(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		/// 컨텐츠 수정
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdSupplier(goodsCommand.getProdSupplier());
		dto.setRecommend(goodsCommand.getRecommend());
		
		/// 파일수정
		String[] fileNames = goodsCommand.getFileDel1().split(","); // 스플릿 하면 일단 length 1개는 만들어짐 (null은 아니라는 말) 
		GoodsDTO dto1 = goodsRepository.goodsDetail(goodsCommand.getProdNum().toString()); // 디비에 저장되어 있는 파일을 가져오기 위해서 만든 dto1,이미 저장되어 있는 파일명 저장
		dto.setProdImage(dto1.getProdImage()); // 디비로부터 가져온 파일명을 현재 dto에 저장했다.
		
		//  파일추가
		String realPath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload"); // 파일 저장할 경로 정해줌
		String storeFile=""; // 저장될 파일네임
		
		if (!goodsCommand.getProdImage()[0].getOriginalFilename().equals("")) { // 배열 길이가 0보다 큼 (전달된 파일이 있다면) // 비어있지않다면 
			for (MultipartFile mf : goodsCommand.getProdImage()) {
				String original = mf.getOriginalFilename();
				String fileNameExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "")+fileNameExt; // 랜덤값 가져오기
				
				File file = new File(realPath + "/" + store);
				try {mf.transferTo(file);}
				catch (Exception e) {e.printStackTrace();}
				storeFile = storeFile + store + ","; // 랜덤값 가져와서 추가해주기
			}
		}
		String goodsFileName = dto1.getProdImage(); 
		if (!fileNames[0].equals("")) { // 파일삭제할 내용이 있다면 (스플릿은 사이즈가 1이 나오기 때문에 첫번째 배열 값이 아예 없다면 으로) 
			// 디비에 있는 이미지 파일명을 제거
			// 이미지 파일이 변경된 경우 수정된 내용으로 다시 저장		
			for(String s : fileNames) { // 스플릿된 애들을 하나씩 불러서 파일 삭제
				String delfile=s + ",";
				goodsFileName = goodsFileName.replace(delfile,""); // 디비에 있는 이미지 파일명을 제거
				File file = new File(realPath + "/" + s);
				if(file.exists()) {file.delete();}
			}
			dto.setProdImage(goodsFileName); 
		}
		dto.setProdImage(storeFile + dto.getProdImage()); // 새로 저장한 파일명 + 원래 있던 파일명
		goodsRepository.goodsUpdate(dto);
	}
}
