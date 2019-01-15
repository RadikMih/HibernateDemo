package hibernate.services.base;

import hibernate.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(int id);
    List<Employee> getAll();
}
