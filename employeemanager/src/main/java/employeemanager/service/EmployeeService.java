package employeemanager.service;

import employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee findEmployeeById(Long id);
}
