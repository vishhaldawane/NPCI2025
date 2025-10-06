
public class InterfaceTest {
	public static void main(String[] args) {
		
		
		Guitar guitar = new Guitar();
		guitar.use();
		guitar.play();
		guitar.tuneStrings();
		guitar.pluck();
		
	}
}

interface Instrument
{
	void use(); //public and abstract
}

abstract class MusicalInstrument implements Instrument
{
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneStrings();
}
//The type Guitar must implement the inherited abstract 
//method StringBasedMusicalInstrument.tuneStrings()
class Guitar extends StringBasedMusicalInstrument
{

	@Override
	public void use() {
		System.out.println("Using the Guitar...");
	}

	@Override
	void tuneStrings() {
		System.out.println("Tuning the Strings of Guitar...");
	}

	@Override
	void play() {
		System.out.println("Playing the Guitar...");
	}

	void pluck() {
		System.out.println("Plucking the Guitar...");
	}
}
/*
 
 
 	B			A
 	|extends	| implements 
 	--------------
 		|
 		C
 		
 	Mammal		Fish
 	|			|
 	-------------
 		  |
 		Whale
 		
 	Mammal		Bird
 		|		|	
 		---------
 			|
 			Bat
 			
 	Bird		Fish
 	  |			  |
 	  -------------
 	  		|
 	  	Penguin
 	  	
 	Mammal		Bird
 	 	|		 |
 	 	----------
 	 		|
 	 	Unicorn
 	   
*/
interface A {
	void fun(); //declared | by default it is public and abstract	
}

interface Q {
	void fee();
}

class B { //B can be an abstract as well if u have such requirement
	void foo() { }
}

class C extends B implements A {
	public void fun() { //mandatory implementation
		
	}
	
}
/*
class D extends B implements A,Q
{
	
}

*/



