package service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.NoticeDTO;
import repository.NoticeRepository;

public class NoticeListService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeList(Model model) {
		List<NoticeDTO> list = noticeRepository.noticeList();
		model.addAttribute("lists",list);
	}
}
