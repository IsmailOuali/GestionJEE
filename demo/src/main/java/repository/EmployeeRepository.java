package repository;


import models.Employee;
import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    void update(Employee employee);
    void delete(int id);
}

