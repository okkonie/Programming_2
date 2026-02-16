import java.util.Scanner;

public class MyStack {

    private final static int STACKMAX = 3;
    private static String[] stack = new String[STACKMAX];
    private static int top = 0;

    static boolean fillStack(String... vals) {
        for (String val : vals) {
          try {
            pushToStack(val);
          } catch (Exception IndexOutOfBoundsException) {
            return false;
          }
        }
            
        return true;
    }

    static void pushToStack(String val) throws IndexOutOfBoundsException {
        stack[top] = val;
        top++;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            System.out.println(fillStack(sc.nextLine()));
        }
    }
}
