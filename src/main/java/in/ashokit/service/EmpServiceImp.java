package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmpRepository;

@Service
public class EmpServiceImp implements EmpService {
	
	private EmpRepository empRepo;
	
	public EmpServiceImp(EmpRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> getEmpInfo() {
		
		return empRepo.findByActiveSW("Y");

	}

	@Override
	public boolean saveEmployee(Employee emp) {
		
		emp.setActiveSW("Y");
		
		Employee isSavedEmp = empRepo.save(emp);
		
		if(isSavedEmp.getEmployeeId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteEmployee(Integer empId) {
//		empRepo.deleteById(empId);
		
		Optional<Employee> findById = empRepo.findById(empId);	
		if(findById.isPresent()) {
			Employee emp = findById.get();
			emp.setActiveSW("N");
			empRepo.save(emp);
		}
		
	}

	@Override
	public Employee editById(Integer empId) {
		
		Optional<Employee> findById = empRepo.findById(empId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
