import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;


public class AnnotationTest {
	@Retention(RUNTIME)
	@Target(TYPE)
	public @interface Garlic {

	}

	public static void main(String[] args) {

		Jar myJar = new  Jar();
		
		
		Class theMirror = myJar.getClass();
		
		//below is a code to probe annotations for the class
		Annotation classStickers[] = theMirror.getAnnotations();
		for(Annotation anno : classStickers) {
			System.out.println("annotation on the class : "+anno);
			
			if(anno instanceof Pickle) {
				System.out.println("Yes I got the Pickle Jar");
				System.out.println("Lets check more details of it....");
			}
			else {
				System.out.println("No its something other than Pickle...");
			}
			System.out.println("-------------");

		}
		
		//below code to probe field level annos
		Field fields[] = theMirror.getFields();
		for(Field field : fields) {
			
			System.out.println("Field name : "+field.getName());
			
			Annotation fieldAnnos[] = field.getAnnotations();
			
			for (Annotation fieldAnno : fieldAnnos) {
				System.out.println("Annotation for the field : "+fieldAnno);
				if(fieldAnno instanceof Lemon) {
					Lemon lemon = (Lemon) fieldAnno; //typecast
					if(lemon.taste().equalsIgnoreCase("sweet")) {
						System.out.println("Yes its sweet lemon pickle jar...till now...");
					}
					else {
						System.out.println("Its a pickle jar, but not sweet....its not my jar sent by my mom...");
					}

				}
				else if(fieldAnno instanceof Weight) {
					Weight weight = (Weight) fieldAnno;
					if(weight.grams() == 3000) {
						System.out.println("It is a lemon Pickle Jar of weight 3000 grams...");
					}
					else {
						System.out.println("It is NOT a lemon Pickle Jar of weight 3000 grams...");
						
					}
				}
				System.out.println("-------------");
			}
		}
		
		System.out.println("================");

		Method methods [] = theMirror.getMethods();
		
		for(Method method : methods ) {
			Annotation methodAnnos [] = method.getAnnotations();
			
			for(Annotation methodAnno : methodAnnos) {
				System.out.println("Method anno : "+methodAnno);
				if(methodAnno instanceof MadeBy) {
					MadeBy mb = (MadeBy) methodAnno;
					if(mb.name().equalsIgnoreCase("mother")) {
						System.out.println("FINALLY GOT THE Pickle Jar of Lemon Sweet type of capactiy 3000 grams made by mother....");
					}
					else {
						System.out.println("its not made by mother");
					}
				}
			}
		}
		
	}
}

@Oil
class Jar
{
	@Garlic(taste="pungent")
	public String content;
	
	@Weight(grams=50)
	public String capacity;
	
	@MadeBy(name="ayurvedicStore")
	public void storeIt() {
		System.out.println("Stored the data in the Jar...");
	}
}