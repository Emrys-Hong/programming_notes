package Week5;

public class LockStaticVariables {
	public static Object saving = 5000;
	public static Object cash = 0;
	
	public static void main(String args[]){   	
		int numberofThreads = 10000;
		WD[] threads = new WD[numberofThreads];
	
		for (int i = 0; i < numberofThreads; i++) {
			threads[i] = new WD();
			threads[i].start();
		}
		
		try {
			for (int i = 0; i < numberofThreads; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("some thread is not finished");
		}
		
		System.out.println("The result is: " + LockStaticVariables.cash);
		System.out.println("The total result is: " + ((int)LockStaticVariables.cash + (int)LockStaticVariables.saving));
	}
}

class WD extends Thread {	
	public void run () {
		synchronized (LockStaticVariables.cash) {
			if ((int)LockStaticVariables.saving >= 1000) {
				System.out.println("I am doing something.");
				LockStaticVariables.saving = (int)LockStaticVariables.saving - 1000;
				LockStaticVariables.cash = (int)LockStaticVariables.cash + 1000;
			}
		}
	}	
}

