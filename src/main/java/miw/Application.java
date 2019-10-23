package miw;

import lombok.extern.slf4j.Slf4j;
import miw.entities.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

	// mvn clean spring-boot:run
	public static void main(String[] args) {
		Car car = Car.builder().id(2).registration("1184CPL").model("Renault Megane").build();
		car.setModel("Madza 1");
		log.info(car.toString());
		car.setModel("Madza 2");
		log.info(car.toString());
		car.setModel("Madza 3");
		log.info(car.toString());
		log.info("------------------------------------------------------------------------------");
		SpringApplication.run(Application.class, args);
	}
}
