import java.util.ArrayList;
import java.util.List;

/* PROBLEM: 
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 
 * 13, 23, 43, 53, 73, and 83, are all prime. By replacing the 3rd and 4th digits of 56**3 with the same digit, 
 * this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the 
 * family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, 
 * is the smallest prime with this property. Find the smallest prime which, by replacing part of the number (not necessarily 
 * adjacent digits) with the same digit, is part of an eight prime value family.
*/


public class PrimeDigitReplacements {
    public static void main(String[] args) 
    {
        int familySize = 8;
        int result = findSmallestPrimeWithFamilySize(familySize);
        System.out.println(result);
    }

    private static int findSmallestPrimeWithFamilySize(int familySize) 
    {
        int digits = 6; // maximum number of digits to check
        int[] primes = generatePrimes(10, (int) Math.pow(10, digits));
        for (int prime : primes) 
        {
            if (prime < 100000) 
            { // skip primes with less than 6 digits
                continue;
            }
            String primeString = Integer.toString(prime);
            for (int mask = 0; mask < (1 << primeString.length()); mask++) 
            {
                List<Integer> family = new ArrayList<>();
                for (int digit = 0; digit <= 9; digit++) 
                {
                    String candidate = applyMask(primeString, mask, digit);
                    if (candidate.charAt(0) == '0') 
                    {
                        continue;
                    }
                    if (isPrime(Integer.parseInt(candidate))) 
                    {
                        family.add(Integer.parseInt(candidate));
                    }
                }
                if (family.size() == familySize) 
                {
                    return family.get(0);
                }
            }
        }
        return -1; // no solution found
    }

    private static String applyMask(String s, int mask, int digit) 
    {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) 
        {
            if (((mask >> i) & 1) == 1) 
            {
                chars[i] = (char) (digit + '0');
            }
        }
        return new String(chars);
    }

    private static boolean isPrime(int n)
    {
        if (n <= 1) 
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if (n % i == 0) 
            {
                return false;
            }
        }
        return true;
    }

    private static int[] generatePrimes(int start, int end) 
    {
        boolean[] isComposite = new boolean[end + 1];
        for (int i = 2; i * i <= end; i++) 
        {
            if (!isComposite[i]) 
            {
                for (int j = i * i; j <= end; j += i) 
                {
                    isComposite[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = start; i <= end; i++) 
        {
            if (!isComposite[i]) 
            {
                count++;
            }
        }
        int[] primes = new int[count];
        int index = 0;
        for (int i = start; i <= end; i++) 
        {
            if (!isComposite[i]) 
            {
                primes[index++] = i;
            }
        }
        return primes;
    }
}
