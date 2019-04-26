package integration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIntegrationApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	}
}
