package ford.app.userApp.user;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "Users") // <--- Add this line!
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private UserRole role;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String gender;



    public enum UserRole {
        ADMIN,
        EMPLOYEE,
        MANAGER,
        GUEST
    }


        public User() {
    }

    public User(Integer userId, String userName, String email, String password, UserRole role, LocalDate dateOfBirth, String gender) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User { ID : "+userId+", Name : "+userName+", Email : "+email+", Role : "+role+", Date of Birth : "+dateOfBirth+", Gender : "+gender+" }\n";
    }
}

