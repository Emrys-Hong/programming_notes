import java.math.BigInteger;


public class FactorPrimeThread {
    BigInteger n;
    int numOfThreads;
    static boolean flag = false;

    public FactorPrimeThread(BigInteger n, int numOfThreads) {
        this.n = n;
        this.numOfThreads = numOfThreads;
    }

    public BigInteger factor() {
        FactorT[] threads = new FactorT[this.numOfThreads];
        for(int i = 0; i<numOfThreads; i++) {
            FactorT factorT = new FactorT(this.n, String.valueOf(this.numOfThreads), new BigInteger(String.valueOf(i+2)));
            threads[i] = factorT;
            threads[i].start();
        }

        while (!flag) {
            for (int i=0; i<numOfThreads; i++) {
                if (!threads[i].isAlive()) {
                    flag = true;
                }
            }
        }


        BigInteger result = null;

        for (int i = 0; i < numOfThreads; i++) {
            if (threads[i].get() != null) {
                result = threads[i].get();
                System.out.println(result);
            }
            else {
                threads[i].interrupt();
            }
        }

        return result;
    }
}

// this is not good because this cannot be interrupt
class FactorT extends Thread{
    BigInteger i;
    BigInteger n;
    String step;
    BigInteger result = null;
    public FactorT (BigInteger n, String step, BigInteger init) {
        this.i = init;
        this.n = n;
        this.step = step;
    }

    @Override
    public void run() {
        BigInteger zero = new BigInteger("0");
        while(i.compareTo(n) < 0) {
            if (isInterrupted()) {
                break;
            }
            if (n.remainder(i).compareTo(zero) == 0) {
                this.result = i;
                FactorPrimeThread.flag = true;
                break;
            }
            i = i.add(new BigInteger(step));
        }
    }



    public BigInteger get(){
        return this.result;
    }
}