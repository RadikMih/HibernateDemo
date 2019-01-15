package hibernate.web;


import hibernate.models.Employee;
import hibernate.services.base.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {

    @MockBean
    EmployeeService mockService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void EmployeeController_GetById_Returns_StatusOK_When_EmployeeExists() throws Exception {
        // Arrange
        Mockito.when(mockService.getById(1))
                .thenReturn(new Employee("fn1", "ln1", "jt1"));

        // Act, Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("fn1"));
    }

    @Test
    public void EmployeeController_GetById_Returns_StatusBadRequest_When_ID_Not_Number() throws Exception {
        // Arrange
        Mockito.when(mockService.getById(2))
                .thenReturn(new Employee("fn1", "ln1", "jt1"));

        // Act, Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/{id}", "abc"))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Unable to parse employee id"));
    }
}
