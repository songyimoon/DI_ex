package main;

import java.util.Scanner;

import main.command.RegisterRequestCommand;
import main.model.CachedMemberDAO;
import main.model.MemberDAO;
import main.service.ChangePasswordService;
import main.service.MemberInfoPrinterService;
import main.service.MemberListPrinterService;
import main.service.MemberPrinter;
import main.service.MemberRegisterService;

public class App { // controller가 됨. 	
	
	static MemberDAO memberDao = new CachedMemberDAO(); // 얘만 바꾸면 다 바뀜
	static MemberPrinter print = new MemberPrinter(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
	
			System.out.println("명령어를 입력하세요: ");
			String command = sc.nextLine();
			if(command.startsWith("new ")) { // 새로 입력
				
				// new 이메일 이름 암호 암호확인
				
				String [] arg = command.split(" ");
				// split으로 배열 [new 이메일 이름 암호 암호확인]
				//                0    1   2   3    4 (인덱스)
				if(arg.length != 5) {
					printHelp();
					System.out.println();
					continue;
				}
				// 명령어를 전달해주는 객체는 의존객체가 아니고 커맨트객체라고 부른다.
				RegisterRequestCommand req = new RegisterRequestCommand();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl= req.isPasswordEqualConfirmPassword();
				if(!bl) { //비밀번호가 틀림
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				// service : controller에서 dao로 값을 전달하기 위해서 꼭 필요함
				// dependency
				MemberRegisterService mrs = new MemberRegisterService(memberDao); // 이 서비스가 디펜던시
				mrs.regist(req); // req는 인자 
				
			}else if(command.startsWith("change ")) {
				String [] arg = command.split(" ");
				if(arg.length != 4) {
					printHelp();
					System.out.println();
					continue;
				}
//				RegisterRequestCommand req = new RegisterRequestCommand();
//				req.setEmail(arg[1]);
//				req.setPassword(arg[2]);
//				req.setConfirmPassword(arg[3]);
				// req는 필요할수도 있고 아닐수도 있어서 의존객체X
				// 의존객체.
				ChangePasswordService chpws = new ChangePasswordService();
				chpws.setMemberDao(memberDao);
				chpws.changePassword(arg[1],arg[2],arg[3]);
			} else if(command.equals("list")) {
				// 의존 객체 
				MemberListPrinterService lp = new MemberListPrinterService();
				lp.printAll();
			} else if (command.startsWith("info")) {
				String [] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					System.out.println();
					continue;
				}
				// 의존객체
				MemberInfoPrinterService mips= new MemberInfoPrinterService();
				mips.setMemberDao(memberDao);
				mips.printMemberInfo(arg[1]);
				
			} else if(command.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			} else {
				printHelp();
			}	
		}
	}
	// 일치하는 명령어가 없을 때 실행되는 함수 
	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법: ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호");
		System.out.println();
	}
}
