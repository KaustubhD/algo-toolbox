import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = (next + current) % 10;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSumBetter(long from, long to) {
      if(to <= 1)
        return to;

      long sum = 0;

      int current = 0;
      int next  = 1;
        
      long temp = 0;
      for(int i = 0; i < from - 1; i++){ // -1 because we start from "from" to "to" in th next loop
        temp = current + next;
        current = next;
        next = (int)temp % 10;
      }

      sum = next; 

      for(int i = 0; i < to - from; i++){
        temp = current + next;
        current = next;
        next = (int)temp % 10;
        sum += next;
      }

      return sum % 10;
  }
    
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long from = 0, to = 0;

    /* 
    // Stress test

    Random rand = new Random();
    int limit = 100;
    long r1 = 0, r2 = 0;
    int temp1 = 0, temp2 = 0;
    while(true){
      temp1 = rand.nextInt(limit) + 1;
      temp2 = rand.nextInt(limit) + 1;
      from = (long)Math.min(temp1, temp2);
      to = (long)Math.max(temp1, temp2);      
      System.out.println(from + " " + to);

      r1 = getFibonacciPartialSumNaive(from, to);
      r2 = getFibonacciPartialSumBetter(from, to);


      System.out.println("Output: " + r1 + "  " + r2 + "\n");
      if(r1 != r2)
        break;
    }
    */

    from = scanner.nextLong();
    to = scanner.nextLong();
    System.out.println(getFibonacciPartialSumBetter(from, to));
  }
}

