package de.hsesslingen.StudienprojektKneisel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("de.hsesslingen.StudienprojektKneisel.Entities")
@SpringBootApplication
public class StudienprojektKneiselApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudienprojektKneiselApplication.class, args);
	}

}
