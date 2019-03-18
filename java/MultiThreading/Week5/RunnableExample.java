package Week5;
public class RunnableExample {    
    public static void main(String[] args) throws Exception {
    	int[] array = {1,2,3,4,5,6,7,8,9};
    	Summer summer1 = new Summer (array, 0, array.length/2+1);
    	Summer summer2 = new Summer (array, array.length/2+1, array.length);
    	
    	Thread thread1 = new Thread(summer1);
    	Thread thread2 = new Thread(summer2);
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
			
			System.out.println("The sum is: " + (summer1.getSum() + summer2.getSum()));
		}
		catch (InterruptedException e) {
			System.out.println("A thread didn't finish!");
		}
    }
}

class Summer implements Runnable {
    	int[] array;
    	int lower;
    	int upper;
    	int sum = 0;
    	
    	public Summer (int[] array, int lower, int upper) {
    		this.array = array;
    		this.lower = lower;
    		this.upper = upper;
    	}
    	
    	public void run() {
    		for (int i = lower; i < upper; i++) {
    			sum += array[i];
    		}
    	}
    	
    	public int getSum() {
    		return sum;
    	}
}
