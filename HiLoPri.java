import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

//Demonstrate thread priorities
class Clicker /*extends Frame */ implements Runnable {
	 long click = 0;
	Thread t;
	private boolean running = true;
	
	Label num = new Label("");

		public Clicker(int p, int x, int y, String title)		{
//			super(title);

//			add(num);
//			setSize(200,100);
//			setLocation(x,y);
			t = new Thread(this);
			t.setPriority(p);
		}

		public void run()		
		{
			while(running) 		
			{
		//		num.setText(""+(++click));
				++click;
			}
		}

		public void stop()  {
			running=false;
		}

		public void start() {
			t.start();
		}
}

public class HiLoPri			{
	public static void main(String[] args) 	{

		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi = new Clicker(Thread.MAX_PRIORITY,100,200,"Hi Priority");
		Clicker lo = new Clicker(Thread.MIN_PRIORITY,200,300,"Low Priority");
	//	hi.setVisible(true);
	//	lo.setVisible(true);

		lo.start();
		hi.start();

		try		{
			Thread.sleep(2500);
		}
		catch (InterruptedException e) 		{
				System.out.println("Main thread interrupted");
		}
		
		lo.stop();
		hi.stop();

		//wait for child threads to terminate
		try		{
					   hi.t.join();
					   lo.t.join();
		}
		catch (InterruptedException e)		{
				System.out.println("InterruptedException caught");
		}

				System.out.println("Low-priority thread :  "+lo.click);
				System.out.println("Hi-priority thread  :  "+hi.click);
	}
}
// lo = 32678065
//hi = 1613291673

