package ford.app.jpa_mappings.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
