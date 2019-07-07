package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load employee data
	
	private EmployeeService employeeServie;
	
	public EmployeeController(EmployeeService employeeServie) {
		this.employeeServie = employeeServie;
	}

	//add mapping for "/list"
	@GetMapping(value="/list")
	public String listEmployees(Model theModel)
	{
		List<Employee> theEmployees = employeeServie.findAll();
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
}
