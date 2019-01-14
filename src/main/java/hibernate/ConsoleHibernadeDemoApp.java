package hibernate;

import hibernate.models.Address;
import hibernate.models.Employee;
import hibernate.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ConsoleHibernadeDemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
//      Employee newEmployee = new Employee("Radik", "Mih", "Junior Dev");

//        session.save(newEmployee);
//        session.getTransaction().commit();
//        session.close();

//        Employee e = session.get(Employee.class, 1);
//        System.out.println(e.getId() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getJobTitle());

//        Town town = new Town("Pleven");
//        System.out.println(town.getId() + " " + town.getName()); // Here Object is in Transient state
//        session.save(town);
//        System.out.println(town.getId() + " " + town.getName());

//        Town t = session.get(Town.class, 34);
//        session.delete(t);

//        List<Town> towns = session.createQuery("FROM Town t WHERE t.name like '%en%'").list();

//        for (Town t : towns){
//            System.out.println(t.getName());
//        }

//        int resultCount = session.createQuery("delete from Town where name = 'Pleven'")
//                .executeUpdate();

//        Employee e = session.get(Employee.class, 2);

        Address a = session.get(Address.class, 6);

        System.out.println(a.getEmployee());

        session.getTransaction().commit();
        session.close();

    }
}
