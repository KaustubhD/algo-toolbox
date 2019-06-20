import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
          return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
          long tmp_previous = previous;
          previous = current;
          current = tmp_previous + current;
          sum += current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciHugeNaive(long n, long m) {
      if (n <= 1)
        return n;

      long previous = 0;
      long current  = 1;

      for (long i = 0; i < n - 1; ++i) {
        long tmp_previous = previous;
        previous = current;
        current += tmp_previous;
        current -= (i == n - 2) ? 1 : 0;
        current %= m;
      }

      return current;
    }


    private static long getFibonacciSumFast(long num){
      if(num <= 1)
        return num;

      num += 2;

      int pisanoLength = 60;  // Pisano length for mod 10
      int index = (int)(num % pisanoLength);

      return getFibonacciHugeNaive(index, 10);  // Last digit i.e. mod 10
    }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = 0L;
   
    /*
    // Stress test

    Random rand = new Random();
    int limit = 100;
    long r1 = 0, r2 = 0;
    while(true){
      n = (long)rand.nextInt(limit) + 1;
      System.out.println(n);

      r1 = getFibonacciSumNaive(n);
      r2 = getFibonacciSumFast(n);


      System.out.println("Output: " + r1 + "  " + r2 + "\n");
      if(r1 != r2)
        break;
    }
    */

    n = scanner.nextLong();

    //long s = getFibonacciSumNaive(n);
    long ans = getFibonacciSumFast(n);

    System.out.println(ans);
  }
}

