public class Fraction{

  //instance variables
  private int num;
  private int dem;

//constructors
  public Fraction (int n, int d){
    //checking for illegal Argument
    try{
        if (d == 0){
          throw (new IllegalArgumentException("Denominator cannot be 0."));
        }
    }// end try
    catch (IllegalArgumentException e){
      System.out.println(e+"\n Denominator changed to 1");
      d=1;
    }//end catch

    //assignment
    this.num = n;
    this.dem = d;

    //bump negative sign
    if (this.dem<0){
      this.dem = this.dem * -1;
      this.num = this.num * -1;
    }//end if
  }//end Fraction

  public Fraction (int n){
    this(n, 1);
  }//end of Fraction

  public Fraction(){
    this(0);
  }//end of Fraction
//end of constructors

//static methods
  public static int gcd(int x, int y){
    int r;
    while (x!=0 && y!=0){
      r=x%y;
      x=y;
      y=r;
    }
    return(x);
  }

//methods
  public int getNumerator(){
    return(this.num);
  }

  public int getDenominator(){
    return(this.dem);
  }

  public String toString(){
    return(this.num+"/"+this.dem);
  }

  public double toDouble(){
    return((double)this.num/this.dem);
  }

  public void toLowesTerms(){
    int d = gcd (this.num, this.dem);
    this.num = this.num/d;
    this.dem = this.dem/d;

    if (this.dem < 0){
      this.num = this.num * -1;
      this.dem = this.dem * -1;
    }
  }

  public Fraction add(Fraction other){
    int n, d;
    n = this.num*other.dem + other.num*this.dem;
    d = other.dem * this.dem;
    Fraction result = new Fraction (n, d);
    result.toLowesTerms();
    return(result);
  }

  public Fraction subtract(Fraction other){
    int n, d;
    n = this.num*other.dem - other.num*this.dem;
    d = other.dem* this.dem;
    Fraction result = new Fraction (n, d);
    result.toLowesTerms();
    return(result);
  }

  public Fraction multiply(Fraction other){
    int n, d;
    n = this.num*other.num;
    d = this.dem*other.dem;
    Fraction result = new Fraction (n, d);
    result.toLowesTerms();
    return (result);
  }

  public Fraction divide(Fraction other){
    int n, d;
    n = this.num*other.dem;
    d = this.dem*other.num;
    Fraction result = new Fraction (n, d);
    result.toLowesTerms();
    return(result);
  }

  public boolean equals(Fraction other){
    return(this.toDouble() == other.toDouble());
  }



}//end of class Fraction
