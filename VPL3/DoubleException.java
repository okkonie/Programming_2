import java.util.Scanner;

public class DoubleException {

    static double convertToDouble(String str) {
 
        double val;

        try {
          val = Double.parseDouble(str);
        } catch (Exception NumberFormatExecption) {
          return Double.NaN;
        }
        
        return val;
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        double d;
        d = convertToDouble(s);
        
        System.out.println(d);
        
        sc.close();
    }
}
