import java.util.Scanner;
import java.util.*;
import java.util.Collections;

public class FractionalKnapsack {
    //private static double getOptimalValue(int capacity, int[] values, int[] weights) {
  private static double getOptimalValue(int available) {
    
    double value = 0;
    //int available = capacity;

    ArrayList<Float> keys = new ArrayList<Float>(map.keySet());
    
    int i = keys.size() - 1;
    int current = 0;

    while(available > 0 && i >= 0 ){
      //System.out.println(keys.get(0));
      current = map.get(keys.get(i));
      if(current >= available){
        value += available * keys.get(i);
        available = 0;        
      }
      else{
        value += current * keys.get(i);
        available -= current;
      }
      i -= 1;
    }

    return value;
  }

  static TreeMap<Float, Integer> map = new TreeMap<>();


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int capacity = scanner.nextInt();
    //int[] values = new int[n];
    //int[] weights = new int[n];
    float temp1 = 0;
    int temp2 = 0;
    for (int i = 0; i < n; i++) {
      temp1 = scanner.nextFloat();
      temp2 = scanner.nextInt();
      map.put(temp1/temp2, temp2);
    }
    System.out.println(getOptimalValue(capacity));
  }
} 
