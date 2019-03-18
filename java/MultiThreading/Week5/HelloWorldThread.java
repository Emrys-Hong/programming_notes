package Week5;

public class HelloWorldThread {
	public static void main (String[] args) {
		double K = 20, a = 1.2, t = 2;
		
		Thread2 thread2 = new Thread2(a,t);
		Thread1 thread1 = new Thread1(K, a, t);
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
			
			System.out.println("Value of Expression: " + thread1.getValue()*thread2.getValue());
		}
		catch (InterruptedException e) {
			System.out.println("A thread didn't finish!");
		}
	}
	
    public static void PrintMatrix (int[][] toprint) {
    	//assume that toprint is a square matrix
    	//assume that toprint is not []
    	for (int i = 0; i < toprint.length; i++) {
        	for (int j = 0; j < toprint[0].length; j++) {
        		System.out.print(toprint[i][j] + "\t");
        	}
    		System.out.println();
    	}
    }
}

class Thread1 extends Thread {
	private double K, a, t, value;
	
	public Thread1 (double K, double a, double t) {
		this.K = K;
		this.a = a;
		this.t = t;
	}
	
	public void run () {
		value = 2*K*a*t;
	}
	
	public double getValue() {
		return value;
	}
}

class Thread2 extends Thread {
	private double a, t, value;
	
	public Thread2 (double a, double t) {
		this.a = a;
		this.t = t;
	}
	
	public void run () {
		value = Math.exp(-a*t*t);
	}
	
	public double getValue() {
		return value;
	}
}