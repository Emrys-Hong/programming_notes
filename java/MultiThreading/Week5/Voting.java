package Week5;

public class Voting {
	public static void main(String args[]){   	
		VoteCounter counter = new VoteCounter ();
		counter.start();
		VoteCollecter collector = new VoteCollecter (counter);
		collector.start();
			
		try {
				collector.join();
				counter.join();
		} catch (InterruptedException e) {
			System.out.println("some thread is not finished");
		}		
	}
}

class VoteCollecter extends Thread {		
	private VoteCounter counter;
	
	public VoteCollecter (VoteCounter counter) {
		this.counter = counter;
	}
	
	public void run () {
		System.out.println ("Voting and collecting.");
		int[] votes = new int[10000];
		
		for (int i = 0; i < 10000; i++) {
			votes[i] = (int) (100*Math.random());
		}
		
		counter.setVotes(votes);
		System.out.println ("Voting finished. Cleaning up.");
	}
}

class VoteCounter extends Thread {	
	private int[] votes;
	
	public void setVotes (int[] votes) {
		this.votes = votes;
		
		synchronized (this) {
			this.votes = votes;
			notifyAll();
		}
	}
	
	public void run () {
		System.out.println ("Preparing for counting.");
		
		//option 1: is the following good?
		while (true) {
			synchronized (this) {
				if (votes != null) {
					break;
				}
			}
		}
		
		/* Question 1: what if the following code is used instead?
		// wait follow these 3 steps, synchronized while, votes
		synchronized (this) {
 			while (true) {
				if (votes != null) {
					break;
				}
			}
		}
		 */
		
		/* Fix 
		synchronized (this) { //mind the order of synchronized and while 
			while (votes == null) { //Q: why a while loop is needed here? To prevent other thread to release the wait
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/

		/* Question 2: what if the following code is used instead? 
		while (votes == null) { 
			synchronized (this) { 
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/
		
		System.out.println ("Counting.");
		
		countVotes(); 
	}
	
	public void countVotes() {
		
	}
}
