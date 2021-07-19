package service.notice;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import model.AuthInfoDTO;

public class NoticeEmpIdService {
	public void empId(Model model, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String employeeId=authInfo.getGrade();
		model.addAttribute("employeeId", employeeId);
	}
}
