package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;

@Service
public interface EmpService {
	
	public List<Employee> getEmpInfo();
	
	
	public boolean saveEmployee(Employee emp);
	
	public void deleteEmployee(Integer empId);
	
	
	public Employee editById(Integer empId);

}
