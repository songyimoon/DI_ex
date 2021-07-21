package service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.EmployeeDTO;
import model.StartEndPageDTO;
import repository.EmployeeRepository;

public class EmployeeListService {
	@Autowired 
	EmployeeRepository employeeRepository;
	public void empList(Model model, int page) {
		
		int limit = 5;
		int limitPage = 10;
		
		Long startRow = ((long)page-1)* limit +1;
		Long endRow = startRow + limit - 1;
		StartEndPageDTO sep = new StartEndPageDTO();
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setStartEndPageDTO(sep);
		
		
		List<EmployeeDTO> list = employeeRepository.empList(dto);
		int count = employeeRepository.count();
		model.addAttribute("empList",list); 	
		
		PageAction pageAction = new PageAction();
		pageAction.page(count, limit, limitPage, page, "empList", model);
	
	}
}
