import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        //return -1;
        
        stops = regulateArray(stops, dist);

        int numRefills = 0, currentPos = 0;
        int len = stops.length - 1;
        // System.out.println(len);
        while(currentPos < len){
          int checkpoint = currentPos;

          while(currentPos < len && stops[currentPos + 1] - stops[checkpoint] <= tank){ // if its less than dist and we have fuel in the tank
            currentPos++;
          }
          // System.out.println("Going from (" + checkpoint + ") " + stops[checkpoint] + " to (" + currentPos + ") "+ stops[currentPos]);
          if(checkpoint == currentPos)
            return -1; // Not Possible
          if(currentPos <= len)
            numRefills++;
        }
        return numRefills - 1;
    }

    static int[] regulateArray(int[] stops, int dist){
      int[] newStops = new int[stops.length + 2];
      newStops[0] = 0;
      for(int i = 0; i < stops.length; i++){
        newStops[i + 1] = stops[i];
      }
      newStops[newStops.length - 1] = dist;
      return newStops;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
