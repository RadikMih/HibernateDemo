package hibernate.services;

import hibernate.data.base.EmployeeRepository;
import hibernate.models.Employee;
import hibernate.services.base.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }
}
