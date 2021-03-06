package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeCommand {
	String employeeId;
	String empUserId;
	String empPw;
	String empPwCon;
	String empName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date hireDate;
	String jobId;
	String PhNumber;
	String officeNumber;
	String empEmail;
	String empAddress;
	String oldEmpPw;
	
	

	public String getOldEmpPw() {
		return oldEmpPw;
	}

	public void setOldEmpPw(String oldEmpPw) {
		this.oldEmpPw = oldEmpPw;
	}

	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpUserId() {
		return empUserId;
	}
	public void setEmpUserId(String empUserId) {
		this.empUserId = empUserId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpPwCon() {
		return empPwCon;
	}
	public void setEmpPwCon(String empPwCon) {
		this.empPwCon = empPwCon;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getPhNumber() {
		return PhNumber;
	}
	public void setPhNumber(String phNumber) {
		PhNumber = phNumber;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	
}
