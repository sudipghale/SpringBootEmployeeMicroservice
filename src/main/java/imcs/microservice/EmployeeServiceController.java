package imcs.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmployeeRestMicroService")
public class EmployeeServiceController {

	@Autowired
	EmployeeService empService;

//-----------------------------------------------------------------------------------------------------------
//getEmployeeInfoAll
	@RequestMapping(value = "/getEmployeeInfoAll", method = RequestMethod.GET, produces = { "application/json" })
	public List<Employee> getEmployeeInfoAll() {
		System.out.println("EmployeeServiceController.getEmployeeInfoAll : START ");
		List<Employee> empList = empService.getEmployeeInfoAll();
		System.out.println("EmployeeServiceController.getEmployeeInfoAll : SIZE=" + empList.size());

		System.out.println("EmployeeServiceController.getEmployeeInfoAll : END ");

		return empList;
	}

//-----------------------------------------------------------------------------------------------------------
//getEmployeeInfoByLastName
	@RequestMapping(value = "/getEmployeeInfoByLastName/{lastName}", method = RequestMethod.GET, produces = {
			"application/json" })
	public List<Employee> getEmployeeInfoByLastName(@PathVariable("lastName") String lastName) {
		System.out.println("EmployeeServiceController.getEmployeeInfoByLastName : START ");
		List<Employee> empList = empService.getEmployeeInfoByLastName(lastName);
		System.out.println("EmployeeServiceController.getEmployeeInfoByLastName : SIZE=" + empList.size());

		System.out.println("EmployeeServiceController.getEmployeeInfoByLastName : END ");

		return empList;
	}

//-----------------------------------------------------------------------------------------------------------
// getEmployeeInfoByLastName
	@RequestMapping(value = "/getEmployeeInfoByEmpId/{empId}", method = RequestMethod.GET, produces = {
			"application/json" })
	public List<Employee> getEmployeeInfoByEmpId(@PathVariable("empId") long empId) {
		System.out.println("EmployeeServiceController.getEmployeeInfoByEmpId : START ");
		List<Employee> empList = empService.getEmployeeInfoByEmpId(empId);
		System.out.println("EmployeeServiceController.getEmployeeInfoByEmpId : SIZE=" + empList.size());

		System.out.println("EmployeeServiceController.getEmployeeInfoByEmpId : END ");

		return empList;
	}

//-----------------------------------------------------------------------------------------------------------
// addEmployee
	@RequestMapping(value = "/addEmployee", 
			method = RequestMethod.POST, 
			produces = { "application/json" })
	public EmployeeResponse addEmployee(@RequestBody Employee employee) {
		System.out.println("EmployeeServiceController.addEmployee : START ");
		EmployeeResponse empResponse = empService.addEmployee(employee);
		System.out.println("EmployeeServiceController.addEmployee : End ");

		return empResponse;

	}

// -----------------------------------------------------------------------------------------------------------
// deleteEmployeeById
	@RequestMapping(value = "/deleteEmployeeById/{empId}", 
			method = RequestMethod.DELETE, 
			produces = { "application/json" })
	public EmployeeResponse deleteEmployeeById(@PathVariable("empId") long empId) {
		System.out.println("EmployeeServiceController.deleteEmployeeById : START ");
		EmployeeResponse empResponse = empService.deleteEmployeeById(empId);
		System.out.println("EmployeeServiceController.deleteEmployeeById : END ");

		return empResponse;

	}

}
