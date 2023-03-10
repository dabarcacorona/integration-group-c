package cl.corona.integrationgroupc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntegrationGroupCApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationGroupCApplication.class, args);
	}

}
