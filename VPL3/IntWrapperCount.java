import java.util.Scanner;

public class IntWrapperCount {
    
    public static int count;
    private int val;

    public IntWrapperCount() {
        val = 0;
    }

    public IntWrapperCount(int ival) {
        count += 1;
        val = ival;
    }
    
    public static int getCount(){
        return count;
    }
    
    public static void main(String [] args) { 
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Anna kokonaisluku: ");
        int count = sc.nextInt();
        
        if (count > 0 && count <= 10) {

            for (int i = 0; i < count; i++) {
                IntWrapperCount iw1 = new IntWrapperCount(i+1);
                System.out.println(IntWrapperCount.check(i+1));
            }
            System.out.println("Luotiin " + getCount() + " olio(ta)");
        }
        else {
            System.out.println("Ei luotu yhtään oliota, count = " + getCount());
        }
    }

    private static int check(int count) {

        if (IntWrapperCount.count == count)
            return count;
        else
            return -1;
    }
}
