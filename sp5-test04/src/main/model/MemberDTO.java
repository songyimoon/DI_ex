package main.model;

import java.util.Date;

public class MemberDTO {
	Long id;
	String email;
	String name;
	String password;
	Date registerDate;
	
	public void changePassword(String oldPw, String newPw) {
		if (password.equals(oldPw)) {
			password = newPw;
		}else {
			System.out.println("현재 비밀번호가 틀립니다.");
		}
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
}
