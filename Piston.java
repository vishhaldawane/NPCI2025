package mycars;

public class Piston {
	String type;
	Piston(String type) {
		this.type = type;
		System.out.println("Piston(String)");

	}
	void firePiston() {
		System.out.println("Piston fired...");
	}
}
