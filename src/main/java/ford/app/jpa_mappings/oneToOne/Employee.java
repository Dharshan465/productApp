package ford.app.jpa_mappings.oneToOne;

import jakarta.persistence.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL)
    // create fk column in employee table
    @JoinColumn(name = "aadhaar_Id",referencedColumnName = "id")
    private Aadhaar aadhaar;

    public Employee() {
    }

    public Employee(String name, Double salary) {

        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Aadhaar getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(Aadhaar aadhaar) {
        this.aadhaar = aadhaar;
    }
}