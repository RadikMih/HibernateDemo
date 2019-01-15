package hibernate.services;

import hibernate.data.base.EmployeeRepository;
import hibernate.models.Employee;
import hibernate.services.base.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class EmployeeServiceImplTests {
    @Test
    public void getAll_Returns_AllEntities_When_CountLessThan5() {
        //Arrange
        EmployeeRepository mockRepository = Mockito.mock(EmployeeRepository.class);
        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                   new Employee("fn1", "ln1", "jt1"),
                   new Employee("fn2", "ln2", "jt2"),
                   new Employee("fn3", "ln3", "jt3")
                ));
        EmployeeService service = new EmployeeServiceImpl(mockRepository);

        //Act
        List<Employee> result = service.getAll();

        //Assert
        Assert.assertEquals(3, result.size());
    }

    @Test

    public void getAll_Returns_5Entities_When_CountMoreThan5() {
        //Arrange
        EmployeeRepository mockRepository = Mockito.mock(EmployeeRepository.class);
        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Employee("fn1", "ln1", "jt1"),
                        new Employee("fn2", "ln2", "jt2"),
                        new Employee("fn3", "ln3", "jt3"),
                        new Employee("fn4", "ln4", "jt4"),
                        new Employee("fn5", "ln5", "jt5"),
                        new Employee("fn6", "ln6", "jt6")
                ));
        EmployeeService service = new EmployeeServiceImpl(mockRepository);

        //Act
        List<Employee> result = service.getAll();

        //Assert
        Assert.assertEquals(5, result.size());
    }
}
