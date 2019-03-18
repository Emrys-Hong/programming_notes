package Week5;
public class InterruptExample1 {    
	public static void main(String args[]){
		AThread t1=new AThread();
		t1.start();
		try{
			Thread.sleep(1000);
			System.out.println("interrupting");
			t1.interrupt();
			
			if (t1.isInterrupted()) {
				System.out.println("t1 is interrupted");				
			}
		}
		catch (Exception e) {
			System.out.println("Exception captured.");
		}
	}
}

class AThread extends Thread{
	public void run(){
		try{
			System.out.println("running");
			Thread.sleep(10000);
			System.out.println("done sleeping");
		}
		catch (InterruptedException e){
			System.out.println("InterruptedException caught");
			//throw new RuntimeException("Thread interrupted...");
		}
	}
}
	