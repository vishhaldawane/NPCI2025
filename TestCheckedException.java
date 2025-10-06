
//java TestCheckedException
//			|
//	JVm's thread "main()" is executed which is running your main method
//java.lang the default package

public class TestCheckedException {
	public static void main(String[] args)  throws Exception
	{
		
		
		System.out.println("Line1....");
		System.out.println("Line2....");
		System.out.println("Line3....");
		
		if(Math.random()%10 > 0.95)
			throw new Exception("some problem1....");
		
		System.out.println("Line4....");
		System.out.println("Line5....");
		System.out.println("Line6....");
		
		if(Math.random()%10 < 0.10)
			throw new RuntimeException("some problem2....");
		
		System.out.println("Line7....");
		System.out.println("Line8....");
		System.out.println("Line9....");
		System.out.println("Line10....");
		
	}
}
