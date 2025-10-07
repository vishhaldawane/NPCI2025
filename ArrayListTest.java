import java.time.LocalDate;
import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		PhoneLog log1 = new PhoneLog("Dialled",LocalDate.now(),"Rejected",0,"Jane");
		PhoneLog log2 = new PhoneLog("Missed",LocalDate.now(),"Rejected",0,"Jack");
		PhoneLog log3 = new PhoneLog("Received",LocalDate.now(),"Accepted",10,"Janet");
		PhoneLog log4 = new PhoneLog("Missed",LocalDate.now(),"Rejected",0,"Julie");
		PhoneLog log5 = new PhoneLog("Dialled",LocalDate.now(),"Accepted",5,"Julia");
		
/*		PhoneLog logArray [] = new PhoneLog[5]; //fixed size / cannot grow
		logArray[0] = log1;
		logArray[1] = log2;
		logArray[2] = log3;
		logArray[3] = log4;
		logArray[4] = log5;*/
	//	logArray[5] = new PhoneLog("Dialled",LocalDate.now(),"Accepted",5,"Robert");
		
		//ctrl+shift+m <-- auto import
		ArrayList<PhoneLog> logList = new ArrayList<PhoneLog>(); 
		System.out.println("Container is created...");
		
		
		logList.add(log1);
		logList.add(log2);
		logList.add(log3);
		logList.add(log4);
		logList.add(log5);
		System.out.println("Content is added to the Container...");
		
		for (PhoneLog phoneLog : logList) {
			System.out.println("Log is : "+phoneLog);
		}
		
		
	}
}
class PhoneLog
{
	String logType; //missed,dialled, recieved
	LocalDate date;
	String  status;
	int duration;
	String name;
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