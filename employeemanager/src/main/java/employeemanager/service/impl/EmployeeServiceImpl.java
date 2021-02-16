package employeemanager.service.impl;

import employeemanager.exception.UserNotFoundException;
import employeemanager.model.Employee;
import employeemanager.repository.EmployeeRepository;
import employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }



    @Override
    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return this.employeeRepository
                .findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
}
