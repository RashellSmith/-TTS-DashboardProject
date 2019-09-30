package tts.backend.dashboardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DashboardAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardAPIApplication.class, args);
	}

}
