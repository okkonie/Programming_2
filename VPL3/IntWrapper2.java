import java.util.Scanner;

public class IntWrapper2 {
    
    private int val = 97;

    public IntWrapper2(int val) {
        if(val > 64 && val < 91)
            this.val = val;
    }

    public int getVal() {
      return val;
    }

    public String toString(){
      return "val (int) = " + val + ", val (char) = " + (char)val;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(); 
        int num2 = sc.nextInt();
        sc.close();

        IntWrapper2 iw1 = new IntWrapper2(num1);
        IntWrapper2 iw2 = new IntWrapper2(num2);
         
        System.out.println(iw1);
        System.out.println(iw2);
        check(iw1, iw2, num1, num2);
    }

    static void check(IntWrapper2 iw1, IntWrapper2 iw2, int n1, int n2) {

        boolean w1 = false, w2 = false;
        if(iw1.getVal() == n1)
            w1 = true;
        if(iw2.getVal() == n2)
            w2 = true;
        
        System.out.println(w1);
        System.out.println(w2);
    }
}
