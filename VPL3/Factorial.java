import java.util.Scanner;

public class Factorial {

    static int factorial(int n) {
      
      int fact = 1;

      for(int i = 1; i <= n; i++){
        fact *= i;
      }

      return fact;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int a = 0;
        int fac = 0;

        System.out.print("Anna kokonaisluku: ");
        a = sc.nextInt();

        fac = factorial(a);
        System.out.println(fac);

        sc.close();
    }
}
