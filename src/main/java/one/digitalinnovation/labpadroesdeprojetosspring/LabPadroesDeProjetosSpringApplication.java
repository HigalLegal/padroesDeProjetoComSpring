package one.digitalinnovation.labpadroesdeprojetosspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabPadroesDeProjetosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesDeProjetosSpringApplication.class, args);
	}

}
