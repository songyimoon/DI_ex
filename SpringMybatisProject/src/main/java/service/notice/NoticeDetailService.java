package service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.NoticeDTO;
import repository.NoticeRepository;

public class NoticeDetailService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeDetail(String noticeNo, Model model) {
		noticeRepository.noticeReadCount(noticeNo);
		NoticeDTO dto = noticeRepository.noticeDetail(noticeNo);		
		model.addAttribute("noticeCommand", dto);
	}
}
