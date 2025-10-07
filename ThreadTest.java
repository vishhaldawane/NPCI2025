public class ThreadTest {
	public static void main(String[] args) {
		//3.
		Car car1 = new Car("Skoda");
		Bike bike = new Bike("\tPulsar");
		Train train = new Train("\t\tVande Bharat");
		
		//4. 
		Thread t1 = new Thread(car1);
		Thread t2 = new Thread(bike);
		Thread t3 = new Thread(train);
		
		t1.start(); 		t2.start();		t3.start();		
	}
}
class Vehicle { }

class Car extends Vehicle implements Runnable//1
{
	String model;
	
	Car(String model) {
		this.model = model;
	}
	public void run() { //2
		for(int i=1;i<=300;i++) {
			System.out.println("Car is running..."+model+ " i "+i);
		}
	}
}

class Bike extends Vehicle implements Runnable//1
{
	String model;
	
	Bike(String model) {
		this.model = model;
	}
	public void run() { //2
		for(int i=1;i<=30;i++) {
			System.out.println("Bike is running..."+model+ " i "+i);
		}
	}
}


class Train extends Vehicle implements Runnable//1
{
	String model;
	
	Train(String model) {
		this.model = model;
	}
	public void run() { //2
		for(int i=1;i<=1000;i++) {
			System.out.println("Train is running..."+model+ " i "+i);
		}
	}
}

/*
class Car extends Thread //1
{
	String model;
	
	Car(String model) {
		this.model = model;
	}
	public void run() { //2
		for(int i=1;i<=300;i++) {
			System.out.println("Car is running..."+model+ " i "+i);
		}
	}
}

class Bike extends Thread //1
{
	String model;
	
	Bike(String model) {
		this.model = model;
	}
	public void run() { //2
		for(int i=1;i<=30;i++) {
			System.out.println("Bike is running..."+model+ " i "+i);
		}
	}
}


class Train extends Thread //1
{
	String model;
	
	Train(String model) {
		this.model = model;
	}
	public void run() { //2
		for(int i=1;i<=1000;i++) {
			System.out.println("Train is running..."+model+ " i "+i);
		}
	}
}
*/
