import java.util.Scanner;

public class Parity {

  static void printParity(int v) {

    if(v % 2 == 0) {
      System.out.println("Parillinen");
    } else {
      System.out.println("Pariton");
    }
  }

    public static void main(String [] args) {

    Scanner sc = new Scanner(System.in);
    int a = 0;

    System.out.println("Enter number");

    a = sc.nextInt();
    
    printParity(a);

    sc.close();
  }
}