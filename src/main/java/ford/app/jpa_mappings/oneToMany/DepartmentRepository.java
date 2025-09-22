package ford.app.jpa_mappings.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
