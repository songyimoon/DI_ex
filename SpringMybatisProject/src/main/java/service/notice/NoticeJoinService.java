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

public class NoticeJoinService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeInsert(NoticeCommand noticeCommand, HttpSession session) {
		NoticeDTO dto = new NoticeDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());
		dto.setNoticeCon(noticeCommand.getNoticeCon());
		dto.setNoticeHits(noticeCommand.getNoticeHits());
		dto.setNoticeKind(noticeCommand.getNoticeKind());
		dto.setNoticeNo(noticeCommand.getNoticeNo());
		dto.setNoticeSub(noticeCommand.getNoticeSub());

		if(!noticeCommand.getNoticeFile()[0].getOriginalFilename().isEmpty()) {
		
			String noticeFile="";
			for (MultipartFile mf : noticeCommand.getNoticeFile()) {
				String original = mf.getOriginalFilename();
				String originalExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "")+originalExt;				
				noticeFile += store + ",";				
				String filePath = session.getServletContext().getRealPath("WEB-INF/view/notice/upload");
				File file = new File(filePath + "/" + store);
				try {mf.transferTo(file);} 
				catch (Exception e) {e.printStackTrace();}
			}
			dto.setNoticeFile(noticeFile);
		}
		noticeRepository.noticeInsert(dto);
	}
}
