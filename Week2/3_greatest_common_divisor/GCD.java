import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd_eucledian(int a, int b) {
    int c = 1;

    if(b > a){ // Swap
      int temp = b; b = a; a = temp;
    }

    while(b != 0){
      c = a % b;
      a = b;      
      b = c;
    }

    return a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = 0;
    int b = 0;

    /*
    // Stress test

    Random rand = new Random();
    int limit = 1000;
    int r1 = 0, r2 = 0;
    while(true){
      a = rand.nextInt(limit) + 1;
      b = rand.nextInt(limit) + 1;
      System.out.println(a + "  " + b);

      r1 = gcd_naive(a, b);
      r2 = gcd_eucledian(a, b);

      System.out.println("Output: " + r1 + "  " + r2 + "\n");
      if(r1 != r2)
        break;
    }
    */

    a = scanner.nextInt();
    b = scanner.nextInt();

    // System.out.println(gcd_naive(a, b));
    
    System.out.println(gcd_eucledian(a, b));    
  }
}
