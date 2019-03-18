

import java.math.BigInteger;

public class FactorThread {    
	public static final int numberOfThreads = 4;
	public static boolean found = false;
	
	public static void main(String[] args) throws Exception {
		//http://en.wikipedia.org/wiki/Fermat_number
		//BigInteger n = new BigInteger("4294967297");
		BigInteger n = new BigInteger("1127451830576035879");
		/*BigInteger n = new BigInteger("160731047637009729259688920385507056726966793490579598495689711866432421212774967" + 
		"02989534032719790175609601429913262345458317707205045275551070134067328238564789969" +
		"4083881316194642417451570483466327782135730575564856185546487053034404560063433614723836456790266457438831626375556854133866958349817172727462462516466898479574402841" +
		"07170390913806245656762456578425410156837840724227320766089203686970819068803335160" + 
		"15394016215765079648415972059527224877506709045229323287315306407064573821626447385" + 
		"38813247139315456213401586618820517823576427094125197001270350087878270889717445401" + 
		"14579223167409894841688886825014359202697385397378512021707795176654693957752089724" + 
		"53921865472795724941776802915065785089627079348791249148808855007264396250330219367" + 
		"28949277390185399024276547035995915648938170415663757378637207011391538009596833354" + 
		"10773715627303749472785830202866336629694392500864734876927203553226504804970982727" + 
		"51793812528986759655285106192583767791710305564828845357288129162166254301870395336" + 
		"68677528079544176897647303445153643525354817413650848544778690688201005274443717680" + 
		"593899");*/
    	
        long startTime = System.currentTimeMillis();   
        BigInteger result = factorMultiThread(n);
        assert(result!=null);
        long duration = System.currentTimeMillis() - startTime;
		BigInteger theother = n.divide(result);
		System.out.println("Factors are: " + result + ", " + theother);
		int seconds = (int) (duration / 1000) % 60 ;
		int minutes = (int) ((duration / (1000*60)) % 60);
		int hours   = (int) ((duration / (1000*60*60)) % 24);
		System.out.print("Time used: " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");
    }
	
	//Precondition: n is a semi-prime number.
	//Postcondition: the returned value is a prime factor of n;		
	public static BigInteger factorMultiThread (BigInteger input) {
		Factor[] factors = new Factor[numberOfThreads];
		
		for (int i = 0; i < numberOfThreads; i++) {
			factors[i] = new Factor (input, i+2, numberOfThreads);
			factors[i].start();
		}
				
		while (!found) {
			for (int i=0; i<numberOfThreads; i++) {
				if (!factors[i].isAlive()) {
					found = true;
				}
			}
		}
		
		BigInteger result = null;

		for (int i = 0; i < numberOfThreads; i++) {
			if (factors[i].getResult() != null) {
				result = factors[i].getResult();
			}
			else {
				factors[i].interrupt();									
			}
		}
		
		return result;
	}
}

class Factor extends Thread {
	BigInteger n;
	BigInteger init;
	BigInteger stepSize;
	BigInteger result;
	
	public Factor (BigInteger n, int init, int stepSize) {
		this.n = n;
		this.init = BigInteger.valueOf(init);
		this.stepSize = BigInteger.valueOf(stepSize);
	}
	
    public void run() {
		BigInteger zero = new BigInteger("0");
		
		while (init.compareTo(n) < 0) {			
			if (isInterrupted()) {
				break;
			}
			
			if (n.remainder(init).compareTo(zero) == 0) {
				result = init;
				FactorThread.found = true;
				break;
			}
			
			init = init.add(stepSize);
		}
	}
    
    public BigInteger getResult() {
    	return result;
    }
 }