public class PrimeNumberChecker{
	public static int isPrime(int num){
        if (num == 2) {
            return 1;
        }
        else {
            for (int i=2; i<=Math.pow(num, 0.5); i++) {
                if (num%i == 0) {
                    return 0;
                }

            }
        }
        return 1;
	}
}

