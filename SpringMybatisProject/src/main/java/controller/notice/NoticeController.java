package controller.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.NoticeCommand;
import service.notice.NoticeDeleteService;
import service.notice.NoticeDetailService;
import service.notice.NoticeEmpIdService;
import service.notice.NoticeJoinService;
import service.notice.NoticeListService;
import service.notice.NoticeNumService;
import service.notice.NoticeUpdateService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	NoticeEmpIdService noticeEmpIdService;
	@Autowired
	NoticeJoinService noticeJoinService;
	@Autowired
	NoticeListService noticeListService;
	@Autowired
	NoticeDetailService noticeDetailService;
	@Autowired
	NoticeUpdateService noticeUpdateService;
	@Autowired
	NoticeDeleteService noticeDeleteService;
	
	@RequestMapping("noticeList")
	public String noticeList(Model model) {
		noticeListService.noticeList(model);
		return "notice/noticeList";
	}	
	@RequestMapping("noticeRegist")
	public String noticeRegist(Model model, HttpSession session) {
		noticeEmpIdService.empId(model, session);
		return "notice/noticeRegist";
	}
	@RequestMapping("noticeJoin")
	public String noticeJoin(NoticeCommand noticeCommand, HttpSession session) {
		noticeJoinService.noticeInsert(noticeCommand,session);
		return "redirect:noticeList";
	}
	
	@RequestMapping("noticeDetail")
	public String noticeDetail(@RequestParam(value = "noticeNo") String noticeNo, Model model) {
		noticeDetailService.noticeDetail(noticeNo,model);
		return "notice/noticeDetail";
	}
	@RequestMapping("noticeModify")
	public String noticeModify(@RequestParam(value = "noticeNo") String noticeNo, NoticeCommand noticeCommand,Model model) {
		noticeDetailService.noticeDetail(noticeNo,model);
		return "notice/noticeModify";
	}
	@RequestMapping("noticeModifyOk")
	public String noticeUpdate(NoticeCommand noticeCommand, HttpSession session){
		noticeUpdateService.noticeUpdate(noticeCommand,session);
		return "redirect:noticeList";
	}
	@RequestMapping("noticeDel")
	public String noticeDel(@RequestParam (value = "noticeNo") String noticeNo) {
		noticeDeleteService.noticeDelete(noticeNo);
		return "redirect:noticeList";
	}
}
