
public class SmallestMultiple {
	
	/* PROBLEM: 
	 *  2520 is the smallest number that can be divided by each of the numbers 
	 *  from 1 to 10 without any remainder. What is the smallest positive number
	 *  that is evenly divisible by all of the numbers from 1 to 20?
	 */
	
    public static void main(String[] args) {
        int n = 20;
        long smallestMultiple = n;
        while (!isDivisibleByAll(smallestMultiple, n)) 
        {
            smallestMultiple += n;
        }
        System.out.println(smallestMultiple);
    }
    
    public static boolean isDivisibleByAll(long num, int n) 
    {
        for (int i = 1; i <= n; i++) 
        {
            if (num % i != 0) 
            {
                return false;
            }
        }
        return true;
    }
}
