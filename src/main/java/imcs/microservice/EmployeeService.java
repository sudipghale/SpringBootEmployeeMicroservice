package imcs.microservice;

import java.util.List;

public interface EmployeeService {

	public List<Employee> getEmployeeInfoAll();
	public List<Employee> getEmployeeInfoByLastName(String lastName);
	public List<Employee> getEmployeeInfoByEmpId(long empId);
	public EmployeeResponse addEmployee(Employee employee);
	public EmployeeResponse deleteEmployeeById(long empId);
	
}
