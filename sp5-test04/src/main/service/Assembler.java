package main.service;

import main.model.MemberDAO;

	// 의존객체 조립기
public class Assembler {
	MemberDAO memberDao;
	MemberPrinter print;
	MemberRegisterService memberRegisterService;
	MemberListPrinterService memberListPrinterService;
	ChangePasswordService changePasswordService;
	MemberInfoPrinterService memberInfoPrinterService;
	
	// 의존객체 생성	
	public Assembler() { // 어셈블러를 이용해서 의존객체를 생성한거임. (new)
		memberDao = new MemberDAO();
		print = new MemberPrinter();
		memberRegisterService = new MemberRegisterService(memberDao);
		memberListPrinterService = new MemberListPrinterService();
		changePasswordService = new ChangePasswordService();
		memberInfoPrinterService = new MemberInfoPrinterService();
	}

	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public MemberPrinter getPrint() {
		return print;
	}

	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}

	public MemberListPrinterService getMemberListPrinterService() {
		memberListPrinterService.setMemberDao(memberDao);
		memberListPrinterService.setPrint(print);
		return memberListPrinterService;
	}

	public ChangePasswordService getChangePasswordService() {
		changePasswordService.setMemberDao(memberDao);
		return changePasswordService;
	}

	public MemberInfoPrinterService getMemberInfoPrinterService() {
		memberInfoPrinterService.setMemberDao(memberDao);
		memberInfoPrinterService.setPrint(print);
		return memberInfoPrinterService;
	}
	
}
