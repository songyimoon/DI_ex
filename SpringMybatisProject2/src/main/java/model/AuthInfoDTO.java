package model;

public class AuthInfoDTO {
	String uesrId;
	String userEmail;
	String userPw;
	String grade;
	
	public String getUesrId() {
		return uesrId;
	}
	public void setUesrId(String uesrId) {
		this.uesrId = uesrId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
