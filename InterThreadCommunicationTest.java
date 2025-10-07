public class InterThreadCommunicationTest {
    public static void main(String[] args) {
        
    	FoodItem foodItems[] = new FoodItem[5];
    	foodItems[0]=new FoodItem("Juice");
    	foodItems[1]=new FoodItem("idli");
    	foodItems[2]=new FoodItem("Wada");
    	foodItems[3]=new FoodItem("Pongal");
    	foodItems[4]=new FoodItem("Tea");
    	

        
        Producer prod = new Producer(foodItems);
        Consumer cons = new Consumer(foodItems);

        prod.setPriority(1);
        cons.setPriority(10);

        prod.start();
        cons.start();
      }
}
class Producer extends Thread {//1
    FoodItem ref[];

    public Producer(FoodItem ref[]) {//3
        this.ref = ref;
    }

    void produce() throws InterruptedException {
        ref[0].served();
    }
    public void run() {//2
        try {
			produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


//FoodItem -> Producer -> Thread -> run() -> produce() -> ref.served()

class Consumer extends Thread {
    FoodItem ref[];

    public Consumer(FoodItem ref[]) {
        this.ref = ref;
    }

     void consume() {
        ref[0].eat();
    }
    public void run() {
        consume();
    }
}

class FoodItem
{
    String foodItemName;

    boolean isProduced;//false

    public FoodItem(String foodItemName) {
        this.foodItemName = foodItemName;
    }
    
    synchronized  void eat() {// Consumer
        if(isProduced==false) {
            System.out.println("Waiting for "+foodItemName+" to be produced....");
            try {
            	//Thread.sleep(500);
                wait(); // super class Object's method
            	//Thread.sleep(1);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        	System.out.println("Consuming...."+foodItemName);
        
    }
    synchronized void served() throws InterruptedException { //Producer
        if(isProduced==false) {
        	//Thread.sleep(500);
        		System.out.println("Producing..." + foodItemName);
   
            isProduced = true;
            notify(); //notifies the waiting thread...
        }
    }
}