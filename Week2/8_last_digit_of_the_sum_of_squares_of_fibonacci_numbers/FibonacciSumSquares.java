import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += (current * current) % 10;
            current %= 10;
        }

        return sum % 10;
    }

  public static int getFibonacciSumSquaresBetter(long n){
    int term1 = (int)fiboHuge_fast(n);
    int term2 = (int)fiboHuge_fast(n + 1);

    return (term1 * term2) % 10;
  }

  private static long getFibonacciHugeNaive(long n) {
        if (n <= 1)
          return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
          long tmp_previous = previous;
          previous = current;
          current = (tmp_previous + current) % 10 ;
        }

        return current;
    }


  private static long fiboHuge_fast(long num){
      
      int len = 60; // for 10
      int index = (int)(num % len);

      return getFibonacciHugeNaive(index);
    }

    
    
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = 0;

    
    // Stress test

    Random rand = new Random();
    int limit = 100;
    long r1 = 0, r2 = 0;
    while(true){
      n = (long)rand.nextInt(limit) + 1;
      System.out.println(n);

      r1 = getFibonacciSumSquaresNaive(n);
      r2 = getFibonacciSumSquaresBetter(n);


      System.out.println("Output: " + r1 + "  " + r2 + "\n");
      if(r1 != r2)
        break;
    }
    


    //n = scanner.nextLong();
    //System.out.println(getFibonacciSumSquaresBetter(n));
  }
}

