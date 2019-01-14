package hibernate.data.base;

import hibernate.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getById(int id);

    List<Employee> getAll();
}
