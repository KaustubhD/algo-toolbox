import java.util.Scanner;

public class Change {
  private static int coins[] = {10, 5, 1};

  private static int getChange(int change) {
    int noOfCoins = 0;
    for(int coin: coins){
      while(change >= coin){
        change -= coin;
        noOfCoins++;
      }
    }
    return noOfCoins;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));

  }
}

