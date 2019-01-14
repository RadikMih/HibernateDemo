package hibernate.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TownID")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany (mappedBy = "town")  // Един град отговоря на много адреси.
    private List<Address> addresses;

    public Town(String name) {
        this.name = name;
    }

    public Town() {
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
