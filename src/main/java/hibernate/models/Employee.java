package hibernate.models;

/* This is a persistent class - class that will be persisted in the database // POJO Class
* Default constructor
* ID field for identification  - this will be mapped to the ID of the table
* private fields with getters and setters
*/


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")  // Mapping to the Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto incremented value
    @Column(name = "EmployeeID")
    private int id;  // Mapping to column

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "JobTitle")
    private String jobTitle;

    @OneToOne
    @JoinColumn(name = "AddressId")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "employeesprojects",
            joinColumns = @JoinColumn(name = "EmployeeID"),
            inverseJoinColumns = @JoinColumn(name = "ProjectID")
    )
    private List<Project> projects;

    public Employee(String firstName, String lastName, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + jobTitle + " " + address;
    }




}
