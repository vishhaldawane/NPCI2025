
public class AbstractTest {
	public static void main(String[] args) {
		//Cannot instantiate the type GeometricalShape
	//	GeometricalShape shape = new GeometricalShape();
		GeometricalShape shape ;
		Square sq = new Square(55);
		sq.draw();
		Rectangle rect = new Rectangle(30, 40);
		rect.draw();
	}
}

//The type GeometricalShape must be 
//an abstract class to define 
//abstract methods
abstract class GeometricalShape
{
	abstract void draw();// partial/incomplete/abstract  contract of a class
}
//no circle option - oval
//no square option - rectangle
//The type Square "must implement" <--MANDATE
//the inherited abstract method GeometricalShape.draw()
class Square extends GeometricalShape
{
	int side;
	Square(int s) { side = s; }
	void draw() {
		System.out.println("Square is drawn....side : "+side);
	}
}

class Rectangle extends Square { //isA
	int side2;
	Rectangle(int s1, int s2) { super(s1); side2 = s2; }
	
	void draw() {
		System.out.println("Rectangle is drawn....side : "+side+ " and side2 : "+side2);
	}
}

/*-- inheritance of derivation --*/
class A{
	void fun() { }
}
class B extends A {
	//not necessary to redefine fun here - not mandatory
}

class C extends A {
	void fun() { } //redefined fun here - optionally overridden
}
/*--------inheritance of implementation---------*/
abstract class P {
	abstract void foo();
}

class Q extends P {
	void foo() { } // MANDATORY /implementation of foo here() is MUST 
}

/*
 *  four [ 4 ] types of methods
	  1. exclusive
	  2. inherited
	  3. overridden
	  4. implemented
*/

abstract class HealthCareProfessional {
	abstract void cure();
}
class Doctor1 extends HealthCareProfessional
{
	void diagnose() { } //1. exclusive
	void chargeFees() {  //300
		System.out.println("Doctor is charging ...100/- INR");
	}
	void cure() { //4. implemented
		
	}
}

class Surgeon1 extends Doctor1 {
	//2. exclusive diagnose() of Doctor is 2. inherited here
	void chargeFees() {  //500
		System.out.println("Surgeon is charging ...500/- INR"); //3. overridden
	}
}

class HeartSurgeon1 extends Surgeon1 {
	//2. exclusive diagnose() of Surgeon->Doctor is 2. inherited here

}











/*

draw a number 6 on the paper
		1. with right hand
		2. direction is anti-clock wise
		
		3. draw a circle on the floor using ur right leg toe
		4. direction is clock
		
		5. above 1 to 4 at once parallel/at the same time
		
		

*/


