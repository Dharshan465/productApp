package ford.app.jpa_mappings.oneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Aadhaar {
    @Id
    @GeneratedValue
    private Integer id; // name of primary key in aadhar table
    private String aadhaarNumber;

    // By directional mapping
    // mappedBy will avoid creation of foreigh key to employee
    @OneToOne(mappedBy = "aadhaar")
    // there will recursion by Jakson lib
    // to avoid add @JsonIgnore
    @JsonIgnore
    private Employee employee;


public Aadhaar() {
    }

    public Aadhaar(String aadharNo) {
        this.aadhaarNumber = aadharNo;
    }
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getAadharNo() {
        return aadhaarNumber;
    }

    public void setAadharNo(String aadharNo) {
        this.aadhaarNumber = aadharNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}