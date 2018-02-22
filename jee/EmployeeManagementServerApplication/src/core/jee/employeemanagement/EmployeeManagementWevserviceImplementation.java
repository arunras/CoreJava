package core.jee.employeemanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import core.jee.employeemanagement.domain.Employee;

@Stateless
@WebService(name="EmployeeManagementWebService")
public class EmployeeManagementWevserviceImplementation {
	@Inject
	private EmployeeManagementServiceLocal service;
	
	public Employee getEmployeeById(int id) {
		return service.getById(id);
	}
	
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
}
