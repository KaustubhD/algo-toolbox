import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static int gcd_eucledian(int a, int b) {
    int c = 1;
    while (b != 0){
      c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

  private static long lcm_fast(int a, int b){
    return ((long)a * b) / gcd_eucledian(a, b);
  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = 0;
    int b = 0;

    /*
    // Stress test

    Random rand = new Random();
    int limit = 1000;
    long r1 = 0, r2 = 0;
    while(true){
      a = rand.nextInt(limit) + 1;
      b = rand.nextInt(limit) + 1;
      System.out.println(a + "  " + b);

      r1 = lcm_naive(a, b);
      r2 = lcm_fast(a, b);


      System.out.println("Output: " + r1 + "  " + r2 + "\n");
      if(r1 != r2)
        break;
    }
    */

    a = scanner.nextInt();
    b = scanner.nextInt();

    //System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a, b));    
  }
}
