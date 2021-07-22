package controller.library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.LibraryCommand;
import controller.FileDownLoad;
import service.library.LibraryDeleteService;
import service.library.LibraryInfoService;
import service.library.LibraryJoinService;
import service.library.LibraryListService;
import service.library.LibraryModifyService;

@Controller
@RequestMapping("lib")

public class LibraryController {
	@Autowired
	LibraryJoinService libraryJoinService;
	@Autowired
	LibraryListService libraryListService;
	@Autowired
	LibraryInfoService libraryInfoService;
	@Autowired
	LibraryModifyService libraryModifyService;
	@Autowired
	LibraryDeleteService libraryDeleteService;
	
	@RequestMapping("libBoard")
	public String libList(Model model) {
		libraryListService.libList(model);
		return "library/libList";
	}
	@RequestMapping("libRegist")
	public String libRegist() {
		return "library/libForm";
	}
	@RequestMapping(value = "libJoin", method = RequestMethod.POST)
	public String libJoin(LibraryCommand libraryCommand, HttpSession session) {
		libraryJoinService.libJoin(libraryCommand,session);
		return "redirect:libBoard";
	}
	@RequestMapping("libraryInfo")
	public String libraryInfo(@RequestParam (value = "noticeNo") String noticeNo, Model model) {
		libraryInfoService.libraryInfo(noticeNo, model);
		return "library/libraryInfo";
	}
	@RequestMapping("libModify")
	public String libModify(@RequestParam (value = "noticeNo") String noticeNo, Model model){
		libraryInfoService.libraryInfo(noticeNo, model);
		return "library/libModify";
	}
	@RequestMapping(value = "libModifyOk", method = RequestMethod.POST)
	public String libModifyOk(LibraryCommand libraryCommand) {
		libraryModifyService.libModify(libraryCommand);
		return "redirect:libraryInfo?noticeNo="+libraryCommand.getNoticeNo();
	}
	@RequestMapping("libDel")
	public String libDel(@RequestParam(value = "noticeNo") String noticeNo) {
		libraryDeleteService.libDel(noticeNo);
		return "redirect:libBoard";
	}
	@RequestMapping("fileDown")
	public void fileDown(
			@RequestParam(value = "str") String store, @RequestParam(value="org") String original,
			HttpServletRequest request, HttpServletResponse response) {
		String path="WEB-INF/view/library/upload";
		FileDownLoad fileDownLoad = new FileDownLoad();
		fileDownLoad.fileDownLoad(path, store,original,request,response);
	}
}
