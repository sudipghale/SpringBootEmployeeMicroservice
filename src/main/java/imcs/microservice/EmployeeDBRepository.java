package imcs.microservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDBRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByLastName(String lastName);
	List<Employee> findByEmpId(long empId);
	
}
