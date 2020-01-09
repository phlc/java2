import java.util.Arrays;
import java.util.ArrayList;

public class Tests{

  public static void main(String[] args){
    int[] test = {1, 2, 3};
    System.out.println(test);
    System.out.println(Arrays.toString(test));

    int[] test2 = test;
    test2[1] = 4;
    for (int i=0; i<test.length; i++){
      System.out.println(test[i]);
    }

    int[][] test3 = {{1,2}, {2,3}};
    System.out.println(Arrays.toString(test3));
    for (int[] row: test3){
      System.out.println(Arrays.toString(row));
    }

    ArrayList<Integer> aList = new ArrayList<Integer>();
    int x=89;
    aList.add(x);
    aList.add(3);
    System.out.println(aList.toString());
  }
}
