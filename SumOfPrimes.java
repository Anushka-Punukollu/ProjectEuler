public class SumOfPrimes {
    /* PROBLEM:
     *  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     *  Find the sum of all the primes below two million.
     */

  public static void main(String[] args) {
        int limit = 2000000;
        boolean[] primes = new boolean[limit];
        long sum = 0;

        for (int i = 0; i < primes.length; i++) 
        {
            primes[i] = true;
        }

        // Use Sieve of Eratosthenes algorithm 
        for (int i = 2; i * i < limit; i++) 
        {
            if (primes[i]) 
            {
                for (int j = i * i; j < limit; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i < limit; i++) 
        {
            if (primes[i]) 
            {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
