
public class SwapTest {
	public static void main(String[] args) {
//AnyPair is a raw type. 
//References to generic type AnyPair<T> should be parameterized	
		
		AnyPair<Integer> intPair = new AnyPair<Integer>(10,20);
		intPair.showPair();
		intPair.swap();
		intPair.showPair();
		
		System.out.println("--------------------");
		AnyPair<Float> floatPair = new AnyPair<Float>(12.4f, 34.5f);
		floatPair.showPair();
		floatPair.swap();
		floatPair.showPair();
		
		System.out.println("--------------------");

		AnyPair<String> strPair = new AnyPair<String>("Jim", "Rohn");
		strPair.showPair();
		strPair.swap();
		strPair.showPair();
		
	}
	
}


class AnyPair<T>
{
	T x ;
	T y ;
	
	AnyPair(T x, T y) {
		this.x = x;
		this.y = y;
	}
	void showPair() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);
	}
	public  void swap() {
		System.out.println("Swappping...");
		T temp = x;
		x = y;
		y = temp;
		System.out.println("Swappped...");
	}
}
/*
class IntegerPair
{
	int x ; //1. DATA
	int y ; //
	
	IntegerPair(int x, int y) { //2. CTOR
		this.x = x;
		this.y = y;
	}
	void showPair() { //3. SHOW
		System.out.println("x : "+x);
		System.out.println("y : "+y);
	}
	public  void swap() { //4. SWAP LOGIC
		System.out.println("Swappping...");
		int temp = x;
		x = y;
		y = temp;
		System.out.println("Swappped...");
	}
}

class FloatPair
{
	float x ;
	float y ;
	
	FloatPair(float x, float y) {
		this.x = x;
		this.y = y;
	}
	void showPair() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);
	}
	public  void swap() {
		System.out.println("Swappping...");
		float temp = x;
		x = y;
		y = temp;
		System.out.println("Swappped...");
	}
}


class StringPair
{
	String x ;
	String y ;
	
	StringPair(String x, String y) {
		this.x = x;
		this.y = y;
	}
	void showPair() {
		System.out.println("x : "+x);
		System.out.println("y : "+y);
	}
	public  void swap() {
		System.out.println("Swappping...");
		String temp = x;
		x = y;
		y = temp;
		System.out.println("Swappped...");
	}
}


*/





