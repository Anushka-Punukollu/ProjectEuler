public class LargestPrimeFactor {

	/* PROBLEM:
	 *  The prime factors of 13195 are 5, 7, 13 and 29.
	 *  What is the largest prime factor of the number 600851475143 ?
	 */
	
	public static void main(String[] args) {
        long n = 600851475143L;
        long largestFactor = 1L;
        
        for (long i = 2L; i * i <= n; i++) 
        {
            while (n % i == 0) 
            {
                largestFactor = i;
                n /= i;
            }
        }
        if (n > 1) 
        {
            largestFactor = n;
        }
        System.out.println(largestFactor);
    }
}
