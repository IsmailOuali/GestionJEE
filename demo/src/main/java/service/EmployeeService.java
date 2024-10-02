package service;

import models.Employee;
import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
