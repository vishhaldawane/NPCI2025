import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WashingMachine washingMachine = new WashingMachine();
		
		Class theMirror = washingMachine.getClass();
		
		Method methods [] = theMirror.getMethods();
		
		for (Method method : methods) {
			System.out.println("Method name  : "+method.getName());
		}
		System.out.println("--------------------");
		
		Constructor ctor[]= theMirror.getDeclaredConstructors();
		for (Constructor constructor : ctor) {
			System.out.println("Constuctor : "+constructor);
		}
		
	}

}
