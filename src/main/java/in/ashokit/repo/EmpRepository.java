package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{
	
	// findByXxx method
	
	public List<Employee> findByActiveSW(String status);

}
