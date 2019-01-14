package hibernate;

import hibernate.models.Address;
import hibernate.models.Employee;
import hibernate.models.Project;
import hibernate.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ConsoleHibernateDemoApp {
//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Town.class)
//                .addAnnotatedClass(Address.class)
//                .addAnnotatedClass(Project.class)
//                .buildSessionFactory();
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        Employee newEmployee = new Employee("Radik", "Mih", "Junior Dev");

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

//        Address a = session.get(Address.class, 6);
//        System.out.println(a.getEmployee());

//        Town t = session.get(Town.class, 32);
//        t.getAddresses().add(new Address("31 Alexander Malinov Blvd."));
//        session.save(t);

//        System.out.println(t.getName());
//        for (Address a : t.getAddresses()) {
//            System.out.println("\t" + a.getText() + " " + a.getEmployee().getFirstName());
//        }

//        Address address = session.get(Address.class, 292);
//        System.out.println(address.getText() + " " + address.getTown().getName());
//
//        Town t = session.get(Town.class, 32);
//        for (Address a : t.getAddresses()) {
//            System.out.println("\t" + a.getText());
//        }

//        Employee e = session.get(Employee.class, 3);
//        System.out.println(e.getFirstName());
//
//        for (Project p : e.getProjects()){
//            System.out.println(p.getName() + " " + p.getDescription());
//        }

//        Project project = session.get(Project.class, 2);
//        System.out.println(project.getName());
//
//        for (Employee employee : project.getEmployees()){
//            System.out.println("\t" + employee.getFirstName() + " " + employee.getLastName());
//        }
//
//        session.getTransaction().commit();
//        session.close();
//
//    }
}
