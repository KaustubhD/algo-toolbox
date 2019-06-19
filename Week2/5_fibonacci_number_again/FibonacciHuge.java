import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
          return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
          long tmp_previous = previous;
          previous = current;
          current = (tmp_previous + current) % m;
        }

        return current;
    }


    private static long fiboHuge_fast(long num, long m){
      
      int len = getPisanoSeqLength(m);
      int index = (int)(num % len);

      return getFibonacciHugeNaive(index, m);
    }

    private static int getPisanoSeqLength(long m){
      long first = 0L, second = 1L, third = 0L;
      int i = 0;
      while(i <= m*m){
        third = (first + second) % m;
        first = second;
        second = third;
        i++;
        if(first == 0L && second == 1L)
          return i;
      }
      return 0;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(fiboHuge_fast(n, m));
    }
}

