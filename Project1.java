import java.util.Arrays;

public class Project1{

  public static void main(String[] args){
    //declarations
    char[][] map = new char[10][10];
    for (char row[]: map)
      Arrays.fill(row, ' ');

    //print greetings
    System.out.println("**** Welcome to Battle Ships game ****\n");
    System.out.println("Right now the see is empty.\n");
    printMap(map);

  }//end of main Function

  /*
  printMap - prints the print
  @param: 2D Array
  */
  public static void printMap (char[][] map){
    //print first line
    System.out.println("  0123456789  ");

    //print changing lines
    for (int i=0; i<map.length; i++){
      System.out.print(i+"|");
      for (int j=0; j<map[i].length; j++){
        System.out.print(map[i][j]);
      }//end for
      System.out.println("|"+i);
    }//end for

    //print last line
    System.out.println("  0123456789  ");
  }//end of printMap
}//end of class Project1
