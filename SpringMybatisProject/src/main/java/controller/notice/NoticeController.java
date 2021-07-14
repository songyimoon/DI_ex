package controller.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.NoticeCommand;
import service.notice.NoticeDetailService;
import service.notice.NoticeEmpIdService;
import service.notice.NoticeListService;
import service.notice.NoticeNumService;

@Controller
@RequestMapping("notice")
public class NoticeController {
	@Autowired
	NoticeNumService noticeNumService;
	@Autowired
	NoticeEmpIdService noticeEmpIdService;
	@Autowired
	NoticeListService noticeListService;
	@Autowired
	NoticeDetailService noticeDetailService;
	
	@RequestMapping("noticeList")
	public String noticeList(Model model) {
		noticeListService.noticeList(model);
		return "notice/noticeList";
	}
	
	@RequestMapping("noticeRegist")
	public String noticeRegist(Model model, HttpSession session) {
		noticeNumService.noticeNo(model);
		noticeEmpIdService.empId(model, session);
		return "notice/noticeRegist";
	}
	@RequestMapping("noticeDetail")
	public String noticeDetail(@RequestParam(value = "noticeNo") String noticeNo, Model model) {
		noticeDetailService.noticeDetail(noticeNo,model);
		return "notice/noticeDetail";
	}
	@RequestMapping("noticeModify")
	public String noticeModify(@RequestParam(value = "noticeNo") String noticeNo, NoticeCommand noticeCommand) {
		return "notice/noticeModify";
	}
}
