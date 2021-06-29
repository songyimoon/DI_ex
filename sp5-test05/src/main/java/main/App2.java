package main;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import main.command.RegisterRequestCommand;
import main.service.ChangePasswordService;
import main.service.MemberInfoPrinterService;
import main.service.MemberListPrinterService;
import main.service.MemberRegisterService;

public class App2 { 
	
	private static GenericXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx=new GenericXmlApplicationContext("classpath:appCtx3.xml");
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("명령어를 입력하세요: ");
			String command = sc.nextLine();
			if(command.startsWith("new ")) { 
				String [] arg = command.split(" ");
				if(arg.length != 5) {
					printHelp();
					System.out.println();
					continue;
				}
				RegisterRequestCommand req = new RegisterRequestCommand();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl= req.isPasswordEqualConfirmPassword();
				if(!bl) { 
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				// 의존객체	
				MemberRegisterService mrs = ctx.getBean("memberRegisterService", MemberRegisterService.class);
				mrs.regist(req); 
				
			}else if(command.startsWith("change ")) {
				String [] arg = command.split(" ");
				if(arg.length != 4) {
					printHelp();
					System.out.println();
					continue;
				}
				// 의존객체			
				ChangePasswordService chpws = ctx.getBean("changePasswordService",ChangePasswordService.class);
				chpws.changePassword(arg[1],arg[2],arg[3]);
			} else if(command.equals("list")) {
				// 의존 객체 
				MemberListPrinterService lp = ctx.getBean("memberListPrinterService",MemberListPrinterService.class);
				lp.printAll();
			} else if (command.startsWith("info")) {
				String [] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					System.out.println();
					continue;
				}
				// 의존객체
				MemberInfoPrinterService mips= ctx.getBean("memberInfoPrinterService",MemberInfoPrinterService.class);
				mips.printMemberInfo(arg[1]);
				
			} else if(command.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				sc.close();
			} else {
				printHelp();
			}	
		}
	}
	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법: ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호");
		System.out.println();
	}
}
