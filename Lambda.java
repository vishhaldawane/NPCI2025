import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {
	public static void main(String[] args) {
		
		
		System.out.println("begin main");
		
		MathActivity activity1 = new Multiplication();
		int output = activity1.expression(100, 20);
		System.out.println("output is : "+output);
		
		System.out.println("---------");
		/*
		 	class Savings { void withdraw(float amt) { } }
		 	Savings sav = new Savings();
		 	sav.withdraw(5000);
		 	
		 	
		  	    (argument) -> { body } 
		  	      arguments -> body
		  	      

		 
		*/
		MathActivity act1 = (x,y) -> x+y; //direct implementation without writing any class/methodname
		MathActivity act2 = (x,y) -> x-y;
		MathActivity act3 = (x,y) -> x*y;
		MathActivity act4 = (x,y) -> x/y;
	
		int output1 = act1.expression(100, 30); System.out.println("output1 : "+output1);
		int output2 = act2.expression(100, 30); System.out.println("output2 : "+output2);
		int output3 = act3.expression(100, 30); System.out.println("output3 : "+output3);
		int output4 = act4.expression(100, 30); System.out.println("output4 : "+output4);
		
	
				//1st implementation
				Consumer<Integer> act5 = (n) -> { System.out.println(n); };	
				//2nd implementation
				Consumer<Integer> act6 = (n) -> { if(n%5==0) System.out.println(n); };
				//3rd implementation
				Consumer<Integer> act7 = (n) -> { if(n%2==0) System.out.println(n); };	
				ArrayList<Integer> listOfNums = new ArrayList<Integer>();
				listOfNums.add(50);listOfNums.add(49);listOfNums.add(21);
				listOfNums.add(82);listOfNums.add(14);listOfNums.add(35);
				listOfNums.add(83);
				
				listOfNums.forEach(    act5);listOfNums.forEach(    act6);
				listOfNums.forEach(    act7);
				
				listOfNums.forEach(    		
						(n) -> 
						{ 
								if(n%7==0)
									System.out.println(n); 
						} 
				);
	
		
	}
	
	
}
//Invalid '@FunctionalInterface' annotation; MathActivity is not a functional interface
//@FunctionalInterface
interface MathActivity
{
	int expression(int x, int y); //declared one and only one function
//	int doSomething();
}












class Addition implements MathActivity
{
	@Override
	public int expression(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}
}
class Subtraction implements MathActivity
{
	@Override
	public int expression(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}
}
class Multiplication implements MathActivity
{
	@Override
	public int expression(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}
}
class Division implements MathActivity
{
	@Override
	public int expression(int x, int y) {
		// TODO Auto-generated method stub
		return x/y;
	}
}
