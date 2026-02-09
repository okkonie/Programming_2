import java.util.Scanner;

public class Exception2 {
   
    public enum ReturnCode {
        SUCCESS, NAN, OUTOFBOUNDS
    };

    private static final int ARRMAX = 10;
    private static String [] store = new String[ARRMAX];

    public static ReturnCode insertProduct(String pos, String val) {
        int i;
        
        try {
          i = Integer.parseInt(pos);
        } catch (Exception NumberFormatExecption) {
          return ReturnCode.NAN;
        }

        try {
          store[i] = val;
        } catch (Exception ArrayIndexOutOfBounds) {
          return ReturnCode.OUTOFBOUNDS;
        }
        
        return ReturnCode.SUCCESS;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        String val = sc.nextLine();
        String pos = sc.nextLine();

        ReturnCode code = insertProduct(pos, val);
        System.out.println(code);
        
        sc.close();
    }
}
