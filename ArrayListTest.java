import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class ArrayListTest {
	public static void main(String[] args) {
		PhoneLog log1 = new PhoneLog("Dialled",LocalDate.now(),"Rejected",10,"Jane");
		PhoneLog log2 = new PhoneLog("Missed",LocalDate.now(),"Rejected",5,"Jack");
		PhoneLog log3 = new PhoneLog("Received",LocalDate.now(),"Accepted",12,"Janet");
		PhoneLog log4 = new PhoneLog("Missed",LocalDate.now(),"Rejected",3,"Julie");
		PhoneLog log5 = new PhoneLog("Dialled",LocalDate.now(),"Accepted",15,"Julia");
		
/*		PhoneLog logArray [] = new PhoneLog[5]; //fixed size / cannot grow
		logArray[0] = log1;
		logArray[1] = log2;
		logArray[2] = log3;
		logArray[3] = log4;
		logArray[4] = log5;*/
	//	logArray[5] = new PhoneLog("Dialled",LocalDate.now(),"Accepted",5,"Robert");
		
		//ctrl+shift+m <-- auto import
	//	ArrayList<PhoneLog> logCollection = new ArrayList<PhoneLog>(); 
		
		//Glass
	//	LinkedList<PhoneLog> logCollection = new LinkedList<PhoneLog>(); 

	//	HashSet<PhoneLog> logCollection = new HashSet<PhoneLog>();
		
		TreeSet<PhoneLog> logCollection = new TreeSet<PhoneLog>();

		System.out.println("Container is created...");
		
		System.out.println("Adding first object");
		
		logCollection.add(log1); //add water 30ml
		
		System.out.println("Adding second object");
		logCollection.add(log2); //add water 30ml
		
		System.out.println("Adding third object");
		logCollection.add(log3); //add water 30ml
		
		System.out.println("Adding fourth object");
		logCollection.add(log4); //add water 30ml
		
		System.out.println("Adding fifth object");
		logCollection.add(log5); //add water 30ml
		
		System.out.println("Content is added to the Container...");
		
		for (PhoneLog phoneLog : logCollection) {
			System.out.println("Log is : "+phoneLog);
		}
		System.out.println("------------");
		
		//Straw
		Iterator<PhoneLog> phoneLogIterator = logCollection.iterator();
		while(phoneLogIterator.hasNext()) {
			PhoneLog theLog = phoneLogIterator.next();
			System.out.println("The log is : "+theLog);
		}
		
	}
}
class PhoneLog implements Comparable<PhoneLog>
{
	String logType; //missed,dialled, recieved
	LocalDate date;
	String  status;
	int duration;
	String name;
	
	@Override
	public int compareTo(PhoneLog o) {
		// TODO Auto-generated method stub
		System.out.println("Comparing "+duration + " with "+o.duration);
		return Integer.compare(duration, o.duration);
	}
	
	public PhoneLog(String logType, LocalDate date, String status, int duration, String name) {
		super();
		this.logType = logType;
		this.date = date;
		this.status = status;
		this.duration = duration;
		this.name = name;
	}
	@Override
	public String toString() {
		return "PhoneLog [logType=" + logType + ", status=" + status + ", duration=" + duration + ", name=" + name
				+ "]";
	}
	
	
	
}
/*

	ArrayList = growable array
	


*/