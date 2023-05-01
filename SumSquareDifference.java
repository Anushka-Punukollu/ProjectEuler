
public class SumSquareDifference {
    public static void main(String[] args) 
    {
        int n = 100;
        int sumOfSquares = n * (n + 1) * (2 * n + 1) / 6;
        int squareOfSum = (int) Math.pow(n * (n + 1) / 2, 2);
        int difference = squareOfSum - sumOfSquares;
        System.out.println(difference);
    }
}
