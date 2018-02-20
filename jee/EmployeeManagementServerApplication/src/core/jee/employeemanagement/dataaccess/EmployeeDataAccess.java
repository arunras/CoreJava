package core.jee.employeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Local;

import core.jee.employeemanagement.domain.Employee;

@Local
public interface EmployeeDataAccess {

	void insert(Employee newEmployee);

	List<Employee> findAll();

	List<Employee> findBySurname(String surname);

}