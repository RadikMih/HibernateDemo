package hibernate.services;

import hibernate.data.base.EmployeeRepository;
import hibernate.models.Employee;
import hibernate.services.base.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }
}
