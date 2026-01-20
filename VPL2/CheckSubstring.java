import java.util.Scanner;

public class CheckSubstring {

    static String getSubstring(String s) {
       
        String ss = new String();
        
        ss = s.split(":")[0];
         
        return ss;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        String s, ss;

        System.out.print("Syötä merkkijono: ");
        s = sc.nextLine();

        ss = getSubstring(s);
        System.out.println(ss);

        sc.close();
    }
}
