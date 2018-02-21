package core.jee.employeemanagement;

import java.util.List;

import javax.ejb.Remote;

import core.jee.employeemanagement.domain.Employee;

@Remote
public interface EmployeeManagementService {
  public void registerEmployee(Employee employee) throws ServiceUnavailableException;
  public List<Employee> getAllEmployees();
  public List<Employee> searchBySurname(String surname);
}
