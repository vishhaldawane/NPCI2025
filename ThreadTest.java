import javax.swing.JFrame;
import javax.swing.JTextField;

public class ThreadTest {
	public static void main(String[] args) {
		//3.
		Car car1 = new Car("Skoda",100,100,150,250);
		Bike bike = new Bike("Pulsar",400,100,150,250);
		Train train = new Train("Rajdhani",800,100,150,250);
		
		//4. 
		Thread t1 = new Thread(car1);
		Thread t2 = new Thread(bike);
		Thread t3 = new Thread(train);
		
		t1.start(); 		t2.start();		t3.start();		//5
	}
}
class Vehicle { }
class Car extends JFrame implements Runnable//1
{
	String model;
	JTextField field = new JTextField(20);
	
	Car(String model,int x, int y, int h, int w) {
		this.model = model;
		setLocation(x,y);
		setSize(w,h);
		add(field);

		setVisible(true);
	}
	public void run() { //2
		for(int i=1;i<=3000000;i++) {
			System.out.println("Car is running..."+model+ " i "+i);
			field.setText("Car is running..."+model+" i "+i);

		}
	}
}

class Bike extends JFrame implements Runnable//1
{
	String model;
	JTextField field = new JTextField(20);

	Bike(String model,int x, int y, int h, int w) {
		this.model = model;
		setLocation(x,y);
		setSize(w,h);
		add(field);
		setVisible(true);
	}
	public void run() { //2
		for(int i=1;i<=3000000;i++) {
			System.out.println("Bike is running..."+model+ " i "+i);
			field.setText("Bike is running..."+model+" i "+i);

		}
	}
}


class Train extends JFrame implements Runnable//1
{
	String model;
	JTextField field = new JTextField(20);

	Train(String model,int x, int y, int h, int w) {
		this.model = model;
		setLocation(x,y);
		setSize(w,h);
		add(field);

		setVisible(true);
	}
	public void run() { //2
		for(int i=1;i<=3000000;i++) {
			System.out.println("Train is running..."+model+ " i "+i);
			field.setText("Train is running..."+model+" i "+i);
			
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
