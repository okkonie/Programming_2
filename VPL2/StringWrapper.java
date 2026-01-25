import java.util.Scanner;

public class StringWrapper {
    
    private String str = "";

    public StringWrapper(int num){
        this.str = Integer.toString(num);
    }

    public StringWrapper(String str) {
         this.str = str;
    }
    
    public String getStr() {
        return str;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int ival = sc.nextInt();
        
        StringWrapper sw = new StringWrapper(ival);
        System.out.println(sw.getStr());
        
        sc.close();
    }
}
