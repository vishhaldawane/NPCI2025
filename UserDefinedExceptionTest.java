public class UserDefinedExceptionTest {
	public static void main(String[] args) {
		System.out.println("Begin main");
		try {
			SedanCar sedanCar = new SedanCar("Skoda");
			sedanCar.startTheCar();
			sedanCar.longDrive();
		}
		
		catch(RuntimeException e) {	
			System.out.println("Some Car problem : "+e.getMessage());
		}
		catch(CarKeyNotFoundException carKeyEx) {
			System.out.println("Car Problem : "+carKeyEx.getMessage());
		}
		System.out.println("End main");		
	}
}
class Car {
	
}
class SedanCar extends Car {
	boolean carKeyFound=false;	
	
	SedanCar(String model) throws CarKeyNotFoundException //mandatory for checked type
	{
		System.out.println("Car() ctor started...");	
		double keyFoundRandomValue = Math.random()%10;
		
		if(keyFoundRandomValue > 0.50) {
			carKeyFound = true; 
			System.out.println("Car key found : "+carKeyFound); startTheCar();
		}
		else { //System.out.println("Car key NOT found Exception....");
			//throw new RuntimeException("Car key not found exception.....");
			throw new CarKeyNotFoundException("Car key not found exception.....");//literally throwing
		}
		System.out.println("Car() ctor over...");
	}
	public void startTheCar() { 
		System.out.println("Car started....");       
	}
	public void longDrive() {
		for(int i=1;i<=30;i++) {
			System.out.println("Car long drive completed : "+i+" kms");
			double speedLimit= Math.random()%10;
			if(speedLimit > 0.95) {
				throw new SpeedLimitException("OMG, Car exceeded the speed of 80 kmph");
			}
		
		}
		System.out.println("Long drive over....");
	}
}


class CarKeyNotFoundException extends Exception
{
	CarKeyNotFoundException(String msg) {
		super(msg);
	}
}


class SpeedLimitException extends RuntimeException
{
	SpeedLimitException(String msg) {
		super(msg);
	}
}




