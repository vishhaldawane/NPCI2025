
public class ExistingExceptionTest {
	public static void main(String[] args) {
		
					//  0  1  2  3  4
		int score[] = { 40,60,70,80,90 };
	
		try
		{
			System.out.println("0th value : "+score[0]);
			System.out.println("2th value : "+score[3]);
			System.out.println("4th value : "+score[4]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index is invalid : "+e.getMessage());
		}
		try {
			String companyName=null;//"National Payments Corporation of India";
			System.out.println("Company name : "+companyName);
			System.out.println("Company name : "+companyName.toLowerCase());
			System.out.println("Company name : "+companyName.toUpperCase());
			System.out.println("Company name : "+companyName.substring(19,97));
		}
		catch(NullPointerException nullPtrEx) {
			System.out.println("Ref is null : "+nullPtrEx.getMessage());
		}
		catch(StringIndexOutOfBoundsException strEx) {
			System.out.println("String index is invalid : "+strEx.getMessage());
		}
		System.out.println("End main...");
	}
}	
