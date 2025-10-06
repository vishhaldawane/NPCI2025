
public class FinalTest {
	public static void main(String[] args) {
		
	}
}

//Jim Rohn =Everything affects everything

/*final */ class Chess //Rishav
{
	final int TOTAL_BLOCKS=64; //cannot be changed
	
	/*final*/ void moveKing() { //math code is written by the developer
		System.out.println("KING is moving 1 step anywhere");
	}
	//moveBishop(), moveRook(), movePawn(), moveKnight(), moveQueen()
}
 //Cannot override the final method from Chess
class GraphicalChess extends Chess { //Jack
	void moveKing() { //cannot be overridden
		super.moveKing();
		System.out.println("KING is  moving N step anywhere on graphics screen");
	}
}
class WebGraphicalChess extends GraphicalChess { //Jane
	
}


class Square
{
	int side;
}

class Rectangle extends Square//isA
{
	int side2;
	
}
class RoundedRectangle extends Rectangle
{
	
}
