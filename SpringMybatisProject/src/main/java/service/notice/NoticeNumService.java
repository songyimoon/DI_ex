package service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.NoticeRepository;

public class NoticeNumService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeNo(Model model) {
		String noticeNo = noticeRepository.noticeNo();
		model.addAttribute("noticeNo", noticeNo);
	}
}
