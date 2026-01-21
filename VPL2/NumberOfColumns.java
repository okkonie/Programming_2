import java.util.Scanner;

public class NumberOfColumns {
    
     static int numOfCols (String s) {
        if(s.isEmpty()){return 0;}
        return s.split(",").length;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int cols;
        String s = "";

        System.out.print("Syötä merkkijono: ");
        s = sc.nextLine();

        cols = numOfCols(s);
        System.out.println(cols);

        sc.close();
    }
}
