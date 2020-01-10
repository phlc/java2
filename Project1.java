import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Project1{

  public static void main(String[] args){
    //declarations
    char[][] map = new char[10][10];
    for (char row[]: map)
      Arrays.fill(row, ' ');

    //print greetings
    System.out.print("\033[H\033[2J"); //clear screen
    System.out.println("**** Welcome to Battle Ships game ****\n");
    System.out.println("Right now the see is empty.\n");
    printMap(map);

    //deployShips
    deployShips(map);
    printMap(map);//test

  }//end of main Function

  /*
  printMap - prints the print
  @param: 2D Array
  */
  public static void printMap (char[][] map){
    //print first line
    System.out.println("  0 1 2 3 4 5 6 7 8 9  ");

    //print changing lines
    for (int i=0; i<map.length; i++){
      System.out.print(i+"|");
      for (int j=0; j<map[i].length; j++){
        if (map[i][j]=='1')
          System.out.print('@');
        else if (map[i][j]=='2')
          System.out.print(' ');
        else
          System.out.print(map[i][j]);
        if (j!=9){
          System.out.print(" ");
        }
      }//end for
      System.out.println("|"+i);
    }//end for

    //print last line
    System.out.println("  0 1 2 3 4 5 6 7 8 9  ");
  }//end of printMap

  /*
  deployShips - fill the map with Ships
  @param: 2D Array
  */
  public static void deployShips(char[][] map){
    //declarations
    Scanner input = new Scanner(System.in);
    int x = -1;
    int y = -1;

    //players ships
    System.out.println("Deploy your ships:");
    for (int i=1; i<=5; i++){
        System.out.print("Coordinate X for ship "+i+".: ");
        x = input.nextInt();
        System.out.print("Coordinate Y for ship "+i+".: ");
        y = input.nextInt();

        //check if coordinates are valid
        if (x>9 || x<0 || y>9 || y<0){
          System.out.println("Sorry, invalid coordinates. Try again.");
          i--;
        }
        else if (map[x][y] != ' '){
          System.out.println("Sorry, invalid coordinates. Try again.");
          i--;
        }
        else{
          map[x][y] = '1';
        }
    }//end for

    //show deployment
    System.out.print("\033[H\033[2J"); //clear screen
    System.out.println("Your ships deployment: ");
    printMap(map);
    System.out.println("\nType C to continue.");
    input.next();


    //computers ships
    System.out.print("\033[H\033[2J"); //clear screen
    System.out.println("\nComputer is deploying his ships.");
    Random rand = new Random();
    for (int i=1; i<=5; i++){
        x = rand.nextInt(10);
        y = rand.nextInt(10);

        //check if coordinates are valid
        if (map[x][y] != ' '){
          i--;
        }
        else{
          map[x][y] = '2';
          System.out.println("Ship "+i+". deployment successful");
        }
    }

    System.out.println();
    System.out.println("\nType C to continue.");
    input.next();
  }//end of deployShips
}//end of class Project1
