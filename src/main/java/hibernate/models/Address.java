package hibernate.models;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int id;

    @Column(name = "AddressText")
    private String text;

    @OneToOne(mappedBy = "address")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "TownID")
    private Town town;

    public Address() {
    }

    public Address(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return text;
    }
}
