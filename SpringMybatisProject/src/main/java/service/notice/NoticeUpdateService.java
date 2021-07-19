package service.notice;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.NoticeCommand;
import model.AuthInfoDTO;
import model.NoticeDTO;
import repository.NoticeRepository;

public class NoticeUpdateService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeUpdate(NoticeCommand noticeCommand, HttpSession session) {
		NoticeDTO dto = new NoticeDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		//컨텐츠 수정
		String employeeId= authInfo.getGrade();
		dto.setEmployeeId(employeeId);
		dto.setNoticeSub(noticeCommand.getNoticeSub());	
		dto.setNoticeCon(noticeCommand.getNoticeCon());
		dto.setNoticeKind(noticeCommand.getNoticeKind());
	//	dto.setNoticeHits(noticeCommand.getNoticeHits());
		
		dto.setNoticeNo(noticeCommand.getNoticeNo());		
		
		//파일수정
		String [] fileNames = noticeCommand.getFileDel1().split(","); // 삭제할 파일
		
		NoticeDTO dto1 = noticeRepository.noticeDetail(noticeCommand.getNoticeNo().toString()); // 아무것도 안한 현재 상태의 dto를 dto1에 저장
		dto.setNoticeFile(dto1.getNoticeFile()); // 현재 파일명 저장 (만약 삭제할 파일이 없다면 여기서 set은 끝남)
		//파일추가
		String realPath = session.getServletContext().getRealPath("WEB-INF/view/notice/upload");
		String storeFile= "";	
		if(!noticeCommand.getNoticeFile()[0].getOriginalFilename().equals("")) {
			for(MultipartFile mf : noticeCommand.getNoticeFile()) {
				String original = mf.getOriginalFilename();
				String originalExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "")+originalExt;
				
				File file = new File(realPath + "/" + store);
				try {mf.transferTo(file);} 
				catch (Exception e) {e.printStackTrace();}
				storeFile = storeFile + store + ",";
			}
		}
		String noticeFileName = dto1.getNoticeFile(); // 원래 있던 파일 이름
		if(!fileNames[0].equals("")) { // 삭제할 파일 있다면
			for(String DelfileName : fileNames) {
				String delFile = DelfileName + ",";
				noticeFileName = noticeFileName.replace(delFile, ""); // delFile이름을 없애버림
				File file = new File(realPath + "/" + DelfileName);
				if(file.exists()) {file.delete();}				
			}
			dto.setNoticeFile(noticeFileName);
		}		
		dto.setNoticeFile(storeFile + dto.getNoticeFile()); // 추가할 파일 네임 + 저장해둔 기존 파일명(삭제를 했다면 윗줄의 noticeFileName이 되었을 것)	
		noticeRepository.noticeUpdate(dto);
	}

}
