package ford.app.jpa_mappings.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Override
//    @Transactional
    public Department getDepartmentById(Integer id) throws Exception {
        // hibernate session starts
//        Department department =
        return  this.departmentRepo.findById(id)
                .orElseThrow(() -> new Exception("Dept not found"));

        // department.getProjects().size();// explictly accessing projects
//        return department.getName();
        //hibernate session ends
    }
}