package mycars;

public class Car
{
	Engine engine;
	
	Car(Engine engine) {
		this.engine = engine;
		System.out.println("Car(Engine)");
	}
	void startCar() {
		System.out.println("Car started...");
	}

}
