package hibernate;

import hibernate.models.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConsoleHibernadeDemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();





    }
}
