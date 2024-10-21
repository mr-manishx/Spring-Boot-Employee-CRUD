package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Employee;
import in.ashokit.service.EmpService;


@Controller
public class EmpController {
	
	private EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/addNewEmp")
	public ModelAndView addNewEmp() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("employ", new Employee());
		
		mav.setViewName("addNewEmp");
		
		
		return mav;
	}
	
	@PostMapping("/employ")
	public ModelAndView saveEmployee(@ModelAttribute("employ")Employee employ) {
		
		ModelAndView mav = new ModelAndView();
		
		boolean status = empService.saveEmployee(employ);
		
		if(status) {
			mav.addObject("succes", "Employee Inserted Successfully..");
		}
		else {
			mav.addObject("errMsg", "Employee Insertion failled..");
		}
		mav.setViewName("addNewEmp");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteEmp(@RequestParam("employeeId")Integer employeeId) {
		
		empService.deleteEmployee(employeeId);
		
		ModelAndView mav = new ModelAndView();
		List<Employee> empList = empService.getEmpInfo();
		mav.addObject("employee", empList);
		
		mav.setViewName("index");
		
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editEmpById(@RequestParam("employeeId") Integer empId) {
		
		Employee empObj = empService.editById(empId);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("employ", empObj);
		mav.addObject("succes", "Edit Employee details");
		
		mav.setViewName("addNewEmp");
		
		return mav;
	}
	
	@GetMapping("/employee")
	public ModelAndView getEmpRecord() {
		
		ModelAndView mav = new ModelAndView();
		
		List<Employee> empList = empService.getEmpInfo();
		mav.addObject("employee", empList);
		
		mav.setViewName("index");
		
		return mav;
	}
}
