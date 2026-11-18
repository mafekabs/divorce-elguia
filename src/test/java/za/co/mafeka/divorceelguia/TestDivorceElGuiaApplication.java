package za.co.mafeka.divorceelguia;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestDivorceElGuiaApplication {
	public static void main(String[] args) {
		SpringApplication.from(DivorceElGuiaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
