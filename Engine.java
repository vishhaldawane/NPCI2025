package mycars;

public class Engine {
	Piston piston;
	
	Engine(Piston piston) {
		this.piston = piston;
		System.out.println("Engine(Piston)");

	}
	void igniteEngine() {
		System.out.println("Engine ignited...");
	}

}
