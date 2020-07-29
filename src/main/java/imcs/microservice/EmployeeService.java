package imcs.microservice;

import java.util.List;

public interface EmployeeService {

	public List<Employee> getEmployeeInfoAll();
	public List<Employee> getEmployeeInfoByLastName(String lastName);
	public List<Employee> getEmployeeInfoByEmpId(long empId);
	public void addEmployee(Employee emp);
	public void deleteEmployee(long empId);
	
}
