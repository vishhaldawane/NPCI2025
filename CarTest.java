package mycars;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) {
		System.out.println("Starting spring container...");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("myCarsConfig.xml");
		
		System.out.println("Spring container started...");
		
		//Car car = (Car) context.getBean("x");
		//car.startCar();
	
	}
}
