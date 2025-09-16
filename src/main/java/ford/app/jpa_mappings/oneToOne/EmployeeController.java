package ford.app.jpa_mappings.oneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final AadharRepository aadharRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, AadharRepository aadharRepository) {
        this.employeeRepository = employeeRepository;
        this.aadharRepository = aadharRepository;
    }


    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

    // best practice using DTO
    @PostMapping("/dto")
    public Employee addNewEmployeeByDto(@RequestBody EmployeeDTO employeeDto) {

        // created Employee transient object and persisted it
        return this.employeeRepository
                .save(new Employee(employeeDto.getName(), employeeDto.getSalary()));
    }

    // Using AadharDto post to existing Employee

    @PostMapping("/dto/aadhar/{employeeId}")
    public Aadhaar addNewAadhar(@RequestBody AadhaarDTO aadharDto, @PathVariable("employeeId") Integer id) throws Exception {
        Aadhaar newAadhar = this.aadharRepository.save(new Aadhaar(aadharDto.getAadhaarNumber()));
        Employee founEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee id does not exists"));
        founEmployee.setAadhaar(newAadhar);
        this.employeeRepository.save(founEmployee);
        return newAadhar;
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer employeeId) throws Exception {
        return this.employeeRepository.findById(employeeId).
                orElseThrow(() -> new Exception("Employee id does not exists"));
    }

    @GetMapping("/aadhar/{aadharId}")
    public Employee getAadharById(@PathVariable("aadharId") Integer aadharId) throws Exception {
        // check if employee is fetched along with aadhar

        Aadhaar foundAadhar = this.aadharRepository.findById(aadharId).
                orElseThrow(() -> new Exception("Employee id does not exists"));

        return foundAadhar.getEmployee();
    }
}
