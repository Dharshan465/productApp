package ford.app.jpa_mappings.oneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department addNewDepartment(@RequestBody Department department) {

        if (department.getProjects() != null) {
            department.getProjects().forEach((p) -> p.setDepartment(department));
            // With helper method
//            for (Project project : department.getProjects()) {
//                department.addProjectToDepartment(project);
//            }
        }
        return this.departmentRepo.save(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id) throws Exception {
        //
//        return this.departmentRepo.findById(id)
//                .orElseThrow(() -> new Exception("Department not found."));
        Department department= this.departmentService.getDepartmentById(id);
        return department;
    }

    @GetMapping("/lazy/{id}")
    public String getDepartmentByIdWithOutProjects(@PathVariable Integer id) throws Exception {
        Department department = this.departmentRepo.findById(id)
                .orElseThrow(() -> new Exception("Department not found."));
        return department.getName(); // send dept info thru dto
    }

    @PostMapping("/{deptId}/project")
    public Project addNewProject(@RequestBody Project project, @PathVariable Integer deptId) throws Exception {
        Department foundDepartment = this.departmentRepo.findById(deptId)
                .orElseThrow(() -> new Exception("Department not found."));
        project.setDepartment(foundDepartment);
        return this.projectRepo.save(project);
    }

    @DeleteMapping("/{id}")
    public Department deleteDepartmentById(@PathVariable Integer id) throws Exception {
        Department foundDepartment = this.departmentRepo.findById(id).orElseThrow(() -> new Exception("Department not found."));

        this.departmentRepo.delete(foundDepartment);
        return foundDepartment;
    }

}