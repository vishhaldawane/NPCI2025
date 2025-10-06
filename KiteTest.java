
public class KiteTest {

	public static void main(String[] args) {
			Kite.showKiteCount();
		Kite k1 = new Kite("Jack","Red",40);
		Kite k2 = new Kite("Jane","Green",50);
		Kite k3 = new Kite("Robert","Blue",60);
			Kite.showKiteCount();
		Kite k4 = new Kite("Smith","Green",70);
		Kite k5 = new Kite("Rahul","Blue",30);
			Kite.showKiteCount();

		k1.fly();
		k2.fly();
		k3.fly();
		k4.fly();
		k5.fly();
		
			k5.kiteFight(k1);
			Kite.showKiteCount();

		}
}










class Kite {
	private String kiteOwner; 
	private String kiteColor; 
	private int kiteLength;
	private boolean flying; //status true or false
	
	private static int kiteCount; //created only once per class

	public static void showKiteCount() {
		System.out.println("Total Kites in the sky : "+kiteCount);
	}
	public Kite(String kiteOwner, String kiteColor, int kiteLength) {
		super();
		this.kiteOwner = kiteOwner;
		this.kiteColor = kiteColor;
		this.kiteLength = kiteLength;
		this.flying = true;
		++kiteCount; //increment the shared variable's value
	}
	void fly() {
		System.out.println(kiteOwner+" is flying a kite of "
									+kiteColor+" color of length "
									+kiteLength+" meter : status : "+flying);
	}
	void kiteFight(Kite x) {
		System.out.println(kiteOwner+" started kite fight with "+x.kiteOwner);
		double val = Math.random()%10;
		if(val > 0.90 ) {
			kiteCount-=2;
			flying=false;
			x.flying=false;
			System.out.println(kiteOwner+" and "+x.kiteOwner+" lost the kites");
		}
		else if ( val > 0.60 && val < 0.80) {
			kiteCount-=1;
			flying=false;
			System.out.println(kiteOwner+"  lost the kite");

		}
		else if ( val > 0.30 && val < 0.50) {
			kiteCount-=1;
			x.flying=false;
			System.out.println(x.kiteOwner+"  lost the kite");

		}
		else {
			System.out.println("No one lost the kite");

		}
	}
	
}







