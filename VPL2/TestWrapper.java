import java.util.Scanner;

class IntWrapper {
    
   private int val;
   
   public void setVal(int val) {
     this.val = val;
   }
   public int getVal() {
     return val;
   }
   
}

public class TestWrapper {
    
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();;

        sc.close();
        
        IntWrapper iw1 = new IntWrapper();
        iw1.setVal(a);

        IntWrapper iw2 = new IntWrapper();
        iw2.setVal(b);
         
        check(a, b, iw1, iw2);
    }

    static void check(int a, int b, IntWrapper iw1, IntWrapper iw2){

        boolean w1 = false, w2 = false;
        
        if(iw1.getVal() == a)
            w1 = true;
        if(iw2.getVal() == b)
            w2 = true;
        
        System.out.println(w1);
        System.out.println(w2);
    }
}