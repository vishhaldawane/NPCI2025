public class UserDefinedExceptionTest {
	public static void main(String[] args) {
		System.out.println("Begin main");
		try {
			SedanCar sedanCar = new SedanCar("Skoda");
			sedanCar.startTheCar();
		}
		
		catch(RuntimeException e) {	System.out.println("Some Car problem : "+e.getMessage()); }
		catch(CarKeyNotFoundException carKeyEx) {
			System.out.println("Car Problem : "+carKeyEx.getMessage());
		}
		System.out.println("End main");		
	}
}
class Car {}
class SedanCar extends Car {
	boolean carKeyFound=false;	
	
	SedanCar(String model) throws CarKeyNotFoundException //mandatory for checked type
	{
		System.out.println("Car() ctor started...");	double keyFoundRandomValue = Math.random()%10;
		if(keyFoundRandomValue > 0.80) {
			carKeyFound = true; System.out.println("Car key found : "+carKeyFound); startTheCar();
		}
		else { //System.out.println("Car key NOT found Exception....");
			//throw new RuntimeException("Car key not found exception.....");
			throw new CarKeyNotFoundException("Car key not found exception.....");//literally throwing
		}
		System.out.println("Car() ctor over...");
	}
	public void startTheCar() { System.out.println("Car started....");         }
}


class CarKeyNotFoundException extends Exception
{
	CarKeyNotFoundException(String msg) {
		super(msg);
	}
}




