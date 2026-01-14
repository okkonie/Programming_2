import java.util.Scanner;

public class Square {

    static int square(int a)
    {
        int result = 0;
        
        result = a*a;
        
        return result;
    }
    
    public static void main(String [] args) {
    
        Scanner sc = new Scanner(System.in);
        int a = 0, sqrt = 0;

        System.out.println("Enter number");

        a = sc.nextInt();
        sqrt = square(a);

        System.out.println(sqrt);

        sc.close();
    }

}