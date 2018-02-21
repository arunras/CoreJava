package core.jee.employeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Local;

import core.jee.employeemanagement.domain.Employee;

@Local
public interface EmployeeDataAccess {

	public abstract void insert(Employee newEmployee);

	public abstract List<Employee> findAll();

	public abstract List<Employee> findBySurname(String surname);

}