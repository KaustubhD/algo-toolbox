import java.util.*;

public class LargestNumber{
  
  private static boolean isGreaterOrEqual(String a, String b){
    return (Integer.parseInt(a+b) >= Integer.parseInt(b+a));
  }
  
  private static String largestNumber(List<String> a){
    String result = "";
    
    while(a.size() > 0){
      String max = "0";
      for(String tmp: a){
        if(isGreaterOrEqual(tmp, max)){
          max = tmp;
        }
      }
      result += max;
      a.remove(max);
    }
    return result;
  }

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<String> a = new ArrayList<>();
    for(int i = 0; i < n; i++){
      a.add(scanner.next());
    }
    System.out.println(largestNumber(a));
  }
}

