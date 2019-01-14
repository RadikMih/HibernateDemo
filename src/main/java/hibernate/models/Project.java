package hibernate.models;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectID")
    private int id;

    @Column(name = "Name")
    private  String name;

    @Column(name = "Description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "employeesprojects",
            joinColumns = @JoinColumn(name = "ProjectID"),
            inverseJoinColumns = @JoinColumn(name = "EmployeeID")
    )
    private List<Employee> employees;

    public Project() {
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
