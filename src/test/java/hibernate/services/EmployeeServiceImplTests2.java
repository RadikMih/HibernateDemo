package hibernate.services;


import hibernate.data.base.EmployeeRepository;
import hibernate.models.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTests2 {
    @Mock
    EmployeeRepository mockRepository;

    @InjectMocks
    EmployeeServiceImpl service;

    @Test
    public void GetAll_Returns_AllEntities_When_CountLessThan5() {
        //Arrange
        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Employee("fn1", "ln1", "jt1"),
                        new Employee("fn2", "ln2", "jt2"),
                        new Employee("fn3", "ln3", "jt3")
                ));

        //Act
        List<Employee> result = service.getAll();

        //Assert
        Assert.assertEquals(3, result.size());
    }


}
