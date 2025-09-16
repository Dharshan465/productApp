package ford.app.productApp.ElectronicProduct;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class ElectronicProduct {

        @Id
        private Integer id;
        private String name;
        private Double price;
        private Integer stock;
        private LocalDate manufacturingDate;
        private String description;

        public ElectronicProduct(){

        }

        public ElectronicProduct(Integer id, String name, Double price, Integer stock, LocalDate manufacturingDate, String description) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.manufacturingDate = manufacturingDate;
            this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
        public String toString() {
            return "Product { ID : "+id+", Name : "+name+", Price : "+price+", Stock : "+stock+", Manufacturing Date : "+manufacturingDate+ "Description : "+description+" }\n";
        }
    }

