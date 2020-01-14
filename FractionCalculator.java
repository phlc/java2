import java.util.Scanner;

public class FractionCalculator{
  public static void main (String[] args){
    //declarations
    Scanner input = new Scanner(System.in);
    String op = "";
    Fraction frac1;
    Fraction frac2;

    //greetings
    System.out.println("\nThis program is a fraction calculator\n");

    //get operation
    op = getOperation(input);

    while (!(op.toLowerCase().equals("q"))){
      frac1 = getFraction(input);
      frac2 = getFraction(input);
      if (op.equals("+")) {
        System.out.println(frac1.toString()+" + "+frac2.toString()+
        " = "+frac1.add(frac2).toString());
      }
      else if (op.equals("-")) {
        System.out.println(frac1.toString()+" - "+frac2.toString()+
        " = "+frac1.subtract(frac2).toString());
      }
      else if (op.equals("*")) {
        System.out.println(frac1.toString()+" * "+frac2.toString()+
        " = "+frac1.multiply(frac2).toString());
      }
      else if (op.equals("/")) {
        System.out.println(frac1.toString()+" / "+frac2.toString()+
        " = "+frac1.divide(frac2).toString());
      }
      else if (op.equals("=")) {
        System.out.println(frac1.toString()+" = "+frac2.toString()+
        " : "+frac1.equals(frac2));
      }
      op = getOperation(input);
    }//end while
  }

  private static String getOperation(Scanner input){

    System.out.print("Please enter an operation(+, -, /, *, =, or Q to quit): ");
    String result = input.next();
    while (!(result.equals("+") || result.equals("-") ||
             result.equals("/") || result.equals("*") ||
             result.equals("=") || result.equals("q") ||
             result.equals("Q"))){
      System.out.print("Invalid input (+, -, /, *, =, or Q to quit): ");
      result = input.next();
             }
    return(result);
  }//end of getOperation Function

  private static boolean isNumber(String s){

    boolean result = true;

    if (s.isEmpty()){
      result = false;
    }
    for (int i=0; i<s.length() && result == true; i++){
      if (s.charAt(i) < '0' || s.charAt(i) > '9')
      {
        result = false;
      }
    }

    return (result);
  }//end of isNumber Function

  private static boolean validFraction(String s){

    if (s.isEmpty()){
      return(false);
    }
    else{
      if (s.charAt(0) == '-'){
        s = s.substring(1);
      }
      s = s.replaceFirst("/", "");
    }
    return(isNumber(s));

  }//end of validFraction Function

  public static Fraction getFraction(Scanner input){
    int sig = 1;
    int n = 0;
    int d = 1;

    System.out.print("Please enter a fraction (a/b) or an integer (a): ");
    String s = input.next();

    while (!validFraction(s)){
      System.out.print("Invalid fraction. Please try again: ");
      s = input.next();
    }

    if (s.charAt(0)=='-'){
      sig = -1;
      s = s.substring(1);
    }

    String[] nd = s.split("/");

    n = sig * Integer.parseInt(nd[0]);

    if (nd.length == 2){
      d = Integer.parseInt(nd[1]);
    }

    return(new Fraction(n, d));
  }//end of getFraction Fuction


}//end of class FractionCalculator
