package imcs.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDBRepository employeeDBRepository;

//-----------------------------------------------------------------------------------------------------------
//getEmployeeInfoAll
	@Override
	public List<Employee> getEmployeeInfoAll() {
		System.out.println("	EmployeeServiceImpl.getEmployeeInfoAll : START ");
		List<Employee> empList = (List<Employee>) employeeDBRepository.findAll();
		System.out.println("	EmployeeServiceImpl.getEmployeeInfoAll : END ");

		return empList;
	}

//-----------------------------------------------------------------------------------------------------------
//getEmployeeInfoByLastName
	@Override
	public List<Employee> getEmployeeInfoByLastName(String lastName) {
		System.out.println("	EmployeeServiceImpl.getEmployeeInfoByLastName : START ");
		List<Employee> empList = employeeDBRepository.findByLastName(lastName);
		System.out.println("	EmployeeServiceImpl.getEmployeeInfoByLastName : END ");

		return empList;
	}

//-----------------------------------------------------------------------------------------------------------
//getEmployeeInfoByEmpId
	@Override
	public List<Employee> getEmployeeInfoByEmpId(long empId) {
		System.out.println("	EmployeeServiceImpl.getEmmployeeInfoByEmpId : START ");
		List<Employee> empList = employeeDBRepository.findByEmpId(empId);
		System.out.println("	EmployeeServiceImpl.getEmmployeeInfoByEmpId : END ");

		return empList;
	}

//-----------------------------------------------------------------------------------------------------------
//addEmployee
	@Override
	public void addEmployee(Employee emp) {
		System.out.println("	EmployeeServiceImpl.addEmployee : START ");
		employeeDBRepository.save(emp);
		System.out.println("	EmployeeServiceImpl.addEmployee : END ");
	}

//-----------------------------------------------------------------------------------------------------------
//deleteEmployee
	@Override
	public void deleteEmployee(long empId) {
		System.out.println("	EmployeeServiceImpl.deleteEmployee : START ");
		employeeDBRepository.deleteById(empId);
		System.out.println("	EmployeeServiceImpl.deleteEmployee : END ");
	}

}
