package core.jee.employeemanagement;

import java.util.List;

import javax.ejb.Local;

import core.jee.employeemanagement.dataaccess.EmployeeNotFoundException;
import core.jee.employeemanagement.domain.Employee;

@Local
public interface EmployeeManagementServiceLocal {
  public void registerEmployee(Employee employee) throws ServiceUnavailableException;
  public List<Employee> getAllEmployees();
  public List<Employee> searchBySurname(String surname);
  public Employee getById(int id) throws EmployeeNotFoundException;
	public List<Employee> getAllEmployeesWhereIdBetween(int firstId, int secondId);
}
