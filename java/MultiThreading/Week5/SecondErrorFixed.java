package Week5;

import java.util.concurrent.atomic.AtomicInteger;

public class SecondErrorFixed {
	
	public static void main(String args[]){   	
		int numberofThreads = 10000;
		WDer2[] threads = new WDer2[numberofThreads];
		AtomicInteger amount = new AtomicInteger(5000);
		
		for (int i = 0; i < numberofThreads; i++) {
			threads[i] = new WDer2(amount);
			threads[i].start();
		}
		
		int totalWithdraw = 0;
		
		try {
			for (int i = 0; i < numberofThreads; i++) {
				threads[i].join();
				totalWithdraw += threads[i].getResult();
			}
		} catch (InterruptedException e) {
			System.out.println("some thread is not finished");
		}
		
		System.out.print("The result is ... ");
		System.out.print("wait for it ... ");
		System.out.println(totalWithdraw);		
	}
}

class WDer2 extends Thread {
	int whatIGot = 0;
	private AtomicInteger amount;
	
	public WDer2 (AtomicInteger amount) {
		this.amount = amount;
	}
	
	public void run () {
		synchronized (amount) {
			if (amount.intValue() >= 1000) {
				System.out.println("I am doing something.");			
				amount.addAndGet(-1000);
				whatIGot = 1000;
			}		
		}
	}	
	
	public int getResult() {
		return whatIGot;
	}
}

