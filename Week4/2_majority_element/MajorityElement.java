import java.util.*;
import java.io.*;

public class MajorityElement {
  
  /*
    Another solution: 
      Maintain a TreeMap of number of occurences
      return true if '''Map.get(Map.lastKey())''' is greater than half of array
    
    Complexity:
      O(n) for TreeMap
      O(log(n)) for .get()
      O(log(n)) for .lastKey()
  */
  
  private static int getMajorityElement(int[] a, int left, int right) {
    if (left == right) {
      return -1;
    }
    if (left + 1 == right) {
      return a[left];
    }

    int left_major = getMajorityElement(a, left, ((left + right) / 2));
    int right_major = getMajorityElement(a, ((left + right) / 2) + 1, right);

    // Check for left array majority element
    int count = 0;
    for(int i = left; i < right; i++){
      if(a[i] == left_major)
        count++;
    }
    // Element is major if it occurs more than half the length of array
    if(count > (right - left) / 2)
      return count;

    // Check for right array majority element
    count = 0;
    for(int i = left; i < right; i++){
      if(a[i] == right_major)
        count++;
    }
    if(count > (right - left) / 2)
      return count;

    return -1;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    if (getMajorityElement(a, 0, a.length) != -1) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }
}

