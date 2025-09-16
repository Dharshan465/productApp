# Spring Data JPA

---

### `ORM (Object Relational Mapping)`:
- A programming technique that allows developers to interact with relational databases using object-oriented programming concepts.
- It maps database tables to Java classes and rows to objects, enabling seamless data manipulation without writing raw SQL queries.
- Popular ORM frameworks in Java include Hibernate and JPA (Java Persistence API).
- Benefits of using ORM:
    - Simplifies database interactions by abstracting SQL queries.
    - Reduces boilerplate code for CRUD operations.
    - Enhances maintainability and readability of code.
    - Supports database-agnostic development, allowing easy switching between different database systems.

### `Hibernate`
- A popular open-source ORM framework that implements the JPA specification.
- It provides a powerful and flexible way to map Java objects to database tables and perform database operations.
- It is difficult to use hibernate without JPA but JPA can be used without hibernate.


### `JPA (Java Persistence API)`
- A specification for managing relational data in Java applications.
- It provides a set of interfaces and annotations for mapping Java objects to database tables and performing CRUD operations.
- JPA is not an implementation itself but defines a standard that ORM frameworks like Hibernate implement.
- Key components of JPA:
- Entity: A lightweight, persistent domain object that represents a table in the database.
- EntityManager: The primary interface for interacting with the persistence context, allowing CRUD operations and queries.
- JPQL (Java Persistence Query Language): A query language similar to SQL but operates on entity objects rather than database tables.

### `SpringBoot Data JPA Project`
- A Spring Boot project that integrates Spring Data JPA, a part of the Spring Data family.
- It simplifies the implementation of JPA-based repositories by providing a set of abstractions and utilities.
- Key features of Spring Data JPA:
- Repository Interfaces: Define repository interfaces that extend JpaRepository or CrudRepository to provide CRUD operations and custom queries.
- Query Methods: Automatically generate queries based on method names, reducing the need for boilerplate code.
- Pagination and Sorting: Built-in support for pagination and sorting of query results.
- Auditing: Automatic tracking of entity creation and modification timestamps.


### `Custom Query` 
- Spring Data JPA allows you to define custom queries using the @Query annotation,Declaring Interfaces,XML Named Query Definition and Annotation-based Configuration.
- You can write JPQL or native SQL queries to retrieve data based on specific criteria.
- Also we can use this in interface which extends JpaRepository or CrudRepository by defining method with method name like findbyName here name is the parameter which decides what to pass in the method.
- Example:
```java
@Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%")
List<Product> searchByName(@Param("keyword") String keyword);
```

### `Named Queries`
- Named queries are predefined JPQL or SQL queries that are defined at the entity level using the @NamedQuery annotation, declaring Interfaces,XML Named Query Definition and Annotation-based Configuration.
- They can be reused across multiple repository methods.
- Example:
```java
@Entity
@NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
public class Product {
    // entity fields and methods
}
```
### `Native Queries`
- Native queries are SQL queries that are executed directly against the database.
- They can be defined using the @Query annotation with the nativeQuery attribute set to true.
- Example:
```java
@Query(value = "SELECT * FROM products WHERE name LIKE %:keyword%", nativeQuery = true)
List<Product> searchByNameNative(@Param("keyword") String keyword);   
```

### `@Modifying`
- The @Modifying annotation is used in Spring Data JPA to indicate that a query method
- performs a modifying operation, such as an update or delete, rather than a select operation.
- It is typically used in conjunction with the @Query annotation to define custom update or delete queries.
- Example:
```java
@Modifying
@Query("UPDATE Product p SET p.stock = p.stock + :amount WHERE p.id = :id")
int updateStock(@Param("id") Long id, @Param("amount") int amount);
```

---

### `Validations in Spring Data JPA`
- Spring Data JPA supports bean validation using the Java Bean Validation API (JSR 380
- Bean validation annotations can be applied to entity fields to enforce constraints such as @NotNull, @Size, @Min, @Max, @Pattern, @Email, etc.
- Example:
```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    @Min(value = 0, message = "Price must be non-negative")
    private Double price;
    @Min(value = 0, message = "Stock must be non-negative")
    private Integer stock;
    // getters and setters
}
```

## GitHub Repository: https://github.com/Dharshan465/productApp.git

---
