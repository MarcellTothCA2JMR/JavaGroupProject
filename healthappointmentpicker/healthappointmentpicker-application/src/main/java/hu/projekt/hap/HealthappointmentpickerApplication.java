package hu.projekt.hap;

import hu.projekt.hap.application.service.DataGenerator2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthappointmentpickerApplication {

	@Autowired
	private DataGenerator2 dataGenerator2;

	public static void main(String[] args) {
		SpringApplication.run(HealthappointmentpickerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			dataGenerator2.createTestData();
			ctx.getBean(HealthappointmentpickerApplication.class).play();
		};
	}

	public void play() {
		
		System.out.println("Udvozollek az orvosi idopontfoglalon!");
	}
}