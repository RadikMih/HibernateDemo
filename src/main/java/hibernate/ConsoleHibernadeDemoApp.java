package hibernate;

import hibernate.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConsoleHibernadeDemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
//      Employee newEmployee = new Employee("Radik", "Mih", "Junior Dev");

//        session.save(newEmployee);
//        session.getTransaction().commit();
//        session.close();

        Employee e = session.get(Employee.class, 1);
        System.out.println(e.getId() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getJobTitle());

        session.getTransaction().commit();
        session.close();

    }
}
