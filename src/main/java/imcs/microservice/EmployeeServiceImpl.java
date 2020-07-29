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
	public EmployeeResponse addEmployee(Employee employee) {
		System.out.println("	EmployeeServiceImpl.addEmployee : START ");
		
		EmployeeResponse empResponse = new EmployeeResponse();
		
				try {
					if(employee.getLastName() !=null && !employee.getLastName().isBlank()) {
						employeeDBRepository.save(employee);
						empResponse.setStatus("OK");
						empResponse.setResponseMessage("Employee Successfully added");
					} else {
						empResponse.setStatus("VALIDATION_ERROR");
						empResponse.setResponseMessage("Please provide the mandetory fields!!!");
					}

				} catch (Exception e) {
					empResponse.setStatus("INTERNAL_ERROR");
					empResponse.setResponseMessage(e.getMessage());
					e.printStackTrace();
				}
		
		System.out.println("	EmployeeServiceImpl.addEmployee : END ");
		
		return empResponse;
	}

//-----------------------------------------------------------------------------------------------------------
//deleteEmployeeById
	@Override
	public EmployeeResponse deleteEmployeeById(long empId) {
		System.out.println("	EmployeeServiceImpl.deleteEmployee : START ");
		
		EmployeeResponse empResponse = new EmployeeResponse();

		try {
			employeeDBRepository.deleteById(empId);
			empResponse.setStatus("OK");
			empResponse.setResponseMessage("Employee Successfully deleted");
		} catch (Exception e) {
			empResponse.setStatus("INTERNAL_ERROR");
			empResponse.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("	EmployeeServiceImpl.deleteEmployee : END ");
		
		return empResponse;

	}
	

}
