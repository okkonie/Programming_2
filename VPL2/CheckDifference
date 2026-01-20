import java.util.Scanner;

public class CheckDifference {

    static boolean almostEqual(double a, double b, double c) {
    
        
        double diff = (a-b) < 0 ? b-a : a-b;
        
       if(diff <= c){return true;}
       
       return false;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        double a, b, c;
        boolean isok = false;

        System.out.print("Anna reaaliluku: ");
        a = sc.nextDouble();
        System.out.print("Anna reaaliluku: ");
        b = sc.nextDouble();
        System.out.print("Anna reaaliluku: ");
        c = sc.nextDouble();

        isok = almostEqual(a, b, c);
        System.out.println(isok);

        sc.close();
    }
}
