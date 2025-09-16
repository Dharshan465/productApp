package ford.app.productApp.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Product {

    @Id
    private Integer id;
    //@NotNull(message = "Product Name cannot be null")
    //@NotBlank(message = "Product Name cannot be blank")
    //@Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "Product Name must be alphanumeric")
    //@Size(min = 3, max = 100, message = "Product Name must be between 3 and 100 characters")


    @NotBlank(message = "Product name should not be null, Empty, white spaces.")
    //  @Size(min = 5, max = 100, message = "product Name must be min 5 and max 100 char length")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
            message = "Username must be 6-12 characters long and contain only letters and numbers.")
    private String name;

    @Min(value=1 , message =" Product Price can't be negative" )
    private Double price;
    private Integer stock;

    @NotNull(message = "Manufacturing date cannot be null")
    @PastOrPresent(message = "Manufacturing date cannot be in the future")
    private LocalDate manufacturingDate;

    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",message = "Invalid email format")
    private String email;
    //password regex

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$",
            message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;

    public Product(){

    }

    public Product(Integer id, String name, Double price, Integer stock, LocalDate manufacturingDate, String email, String password) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.manufacturingDate = manufacturingDate;
        this.email = email;
        this.password = password;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
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

    @Override
    public String toString() {
        return "Product { ID : "+id+", Name : "+name+", Price : "+price+", Stock : "+stock+", Manufacturing Date : "+manufacturingDate+" }\n";
    }
}
