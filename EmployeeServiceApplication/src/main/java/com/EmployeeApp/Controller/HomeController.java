package com.EmployeeApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeApp.DTO.EmployeeDTO;
import com.EmployeeApp.Service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/Home")
	public String home() {
		return "Register.jsp";
		
	}
	
	@RequestMapping("getData")
	public ModelAndView getData(EmployeeDTO employeeDTO) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeDTO",employeeDTO);
		mv.setViewName("Home.jsp");
		employeeService.insertEmployee(employeeDTO);
		System.out.println(employeeService.displayEmployee());
		return mv;
	}
	
//	public void displayAllEmployee() {
//		employeeService.displayEmployee();
//	}
}
