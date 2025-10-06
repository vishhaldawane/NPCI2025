
public class InheritanceTest {
	public static void main(String[] args) {
		GrandFather gf = new GrandFather("Grandpaa"); //default ctor
		gf.freedomFigher();
		gf.justice();
	
		
		System.out.println("------------------");
		
		Father father = new Father(90);
		father.freedomFigher();
		father.justice();
		father.business();
	
		
		System.out.println("------------------");
		
		Child child = new Child(10,20,30);
		child.freedomFigher();
		child.business();
		child.justice();
		child.service();
		
	}
}

class GrandFather
{
	GrandFather(String str) {
		System.out.println("GrandFather().....ctor......."+str);
	}
	void freedomFigher() { //1. exclusive 
		System.out.println("GF: Fighting for the freedom...of the country....");
	}
	void justice() {
		System.out.println("GrandFather is justifying......");
	}
}

class Father extends GrandFather //father is extending 
{
	Father(int x) {
		super("sample");
		System.out.println("Father().....ctor.......");
	}
	void business() { //1. exclusive
		System.out.println("Father is farming ....in the farm.....");
	}
	void freedomFigher() { //1. exclusive 
		System.out.println("F: Fighting for the freedom...of the subsidies grom the govt.....");
	}
}

class Child extends Father
{
	//Implicit super constructor Father() is undefined.
	//Must explicitly invoke another constructor
	Child(int i, int j, int k) {
		super(987); //default line of every ctor in java
		System.out.println("Child().....ctor.......");
	}
	void service() {
		System.out.println("Child is servicing the nation.....");
	}
	void freedomFigher() { //1. exclusive 
		
		System.out.println("C: Fighting for the freedom...of the mobile phone dopamine.........");
	}
}
