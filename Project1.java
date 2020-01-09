import java.util.Arrays;

public class Project1{

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
  }
}
