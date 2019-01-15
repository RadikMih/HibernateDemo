package hibernate.web;


import hibernate.models.Employee;
import hibernate.services.base.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") String id) {
     return service.getById(Integer.parseInt(id));
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @ExceptionHandler
    ResponseEntity<EmployeeError> handleException(NumberFormatException e) {
        return new ResponseEntity<>(new EmployeeError(
                HttpStatus.BAD_REQUEST.value(), "Unable to parse employee id"),
                HttpStatus.BAD_REQUEST);
    }
}
