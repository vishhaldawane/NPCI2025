package jungle.cave;


public class Tiger { //a public class's default ctor is also public 

	          int defaultData=100;
	private   int privateData=200;
	protected int protectedData=300;
	public    int publicData=400;
	
	public Tiger() {
		System.out.println("Tiger() ctor...");
	}
	public void roar() {
		System.out.println("Tiger is roaring.....");
	}
}

class ButterFly
{
	void fly() {
		Tiger tiger = new Tiger();
//		System.out.println("defaultData   : "+tiger.defaultData);
//		System.out.println("privateData   : "+tiger.privateData);
//		System.out.println("protectedData : "+tiger.protectedData);
//		System.out.println("publicData    : "+tiger.publicData);
		
		
	}
}





