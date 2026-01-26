import java.util.Scanner;

public class IntWrapper {
    
    private int val;

    public int getVal() {
        return val;
    }
    public void setVal(int val) {
      if(val > 9 && val < 101){
        this.val = val;
      }
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        IntWrapper iw1 = new IntWrapper();
        IntWrapper iw2 = new IntWrapper();
        sc.close();

        int num1 = sc.nextInt();
        iw1.setVal(num1);
        int num2 = sc.nextInt();
        iw2.setVal(num2);

        check(iw1, iw2, num1, num2);
    }

    static void check(IntWrapper iw1, IntWrapper iw2, int n1, int n2) {

        boolean w1 = false, w2 = false;
        if(iw1.getVal() == n1)
            w1 = true;
        if(iw2.getVal() == n2)
            w2 = true;
        
        System.out.println(w1);
        System.out.println(w2);
    }
}
