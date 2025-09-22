package ford.app.jpa_mappings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(scanBasePackages = "ford.app.jpa_mappings")
@SpringBootApplication(scanBasePackages = "ford.app.jpa_mappings")
public class jpaMappingsApplication  { //implements CommandLineRunner

//    @Autowired
//    private ProjectRepository projectRepo;
//    @Autowired
//    private EmployeeRepository employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(jpaMappingsApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//    }
}

