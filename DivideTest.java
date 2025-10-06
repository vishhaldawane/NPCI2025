
public class DivideTest {
	public static void main(String[] args) {
		System.out.println("DivideTest : main started...");
		
		Calculator calci = new Calculator();
		
		calci.divide("10", "5");
		
		try
		{
			calci.divide("10", "abc");
		}
		catch(NumberFormatException e) {
			System.out.println("Please supply numeric value : "+e.getMessage());
		}
		catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero...."+e.getMessage());
		}
		
		try {
			calci.divide("210", "3");//line 9
		}
		catch(ArithmeticException e) {
			System.out.println("Problem : "+e.getMessage());
		}
		calci.divide("50", "3");
		calci.divide("90", "8");
		
		System.out.println("DivideTest : main over...");
		
		
	}
}

class Calculator
{
	void divide(String num, String deno) {//210 0
		System.out.println("divide started....");
		int x = Integer.parseInt(num);
		int y = Integer.parseInt(deno);
		System.out.println("num  : "+x);
		System.out.println("deno : "+y);
		int div = x / y;//throw new ArithmeticException("/ by zero"); // line 25
		System.out.println("div  : "+div);
		System.out.println("divide finished...");
		System.out.println("-----------------------------");
	}
}
