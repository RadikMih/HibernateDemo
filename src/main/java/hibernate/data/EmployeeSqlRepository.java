package hibernate.data;

import hibernate.data.base.EmployeeRepository;
import hibernate.models.Address;
import hibernate.models.Employee;
import hibernate.models.Project;
import hibernate.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSqlRepository implements EmployeeRepository {
    private static final SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
    }

    @Override
    public Employee getById(int id) {
     Employee employee = null;
     try(Session session = factory.openSession()) {
         session.beginTransaction();
         employee = session.get(Employee.class, id);
         session.getTransaction().commit();
     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
     return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            employees = session.createQuery("FROM Employee").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }
}
