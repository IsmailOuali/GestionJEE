package service.impl;

import models.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        this.employeeRepository = new EmployeeRepositoryImpl();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.delete(id);
    }
}
