import java.util.*;

public class CoveringSegments {

  private static Integer[] optimalPoints(Segment[] segments) {
    ArrayList<Integer> points = new ArrayList<>();
    
    Collections.sort(Arrays.asList(segments), (a, b) -> a.end - b.end);
    
    int ind = 0;
    int len = segments.length;
    int current = 0;

    while(ind < len){
      current = ind;
      
      while(ind < len - 1 && segments[ind + 1].start <= segments[current].end){
        ind++;
      }
      points.add(segments[current].end);
      ind++;
    }
    return points.toArray(new Integer[points.size()]);
  }

  private static class Segment {
    int start, end;

    Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Segment[] segments = new Segment[n];
    for (int i = 0; i < n; i++) {
      segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
    }
    Integer[] points = optimalPoints(segments);
    System.out.println(points.length);
    for (int point : points) {
      System.out.print(point + " ");
    }
  }
}
 
