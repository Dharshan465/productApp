package ford.app.jpa_mappings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "ford.app.jpa_mappings")
public class jpaMappingsApplication {
        public static void main(String[] args) {
            SpringApplication.run(jpaMappingsApplication.class, args);
        }

    }

