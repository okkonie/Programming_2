import java.util.Scanner;

public class StringWrapper {
    
    private String str = "Ei arvoa";
    
    public void setStr(String newstr) {
        str = newstr;
    }
    
    public void setStr(int ival) {
        if(ival > 9 && ival < 51)
          str = Integer.toString(ival);
    }
     
    public String getStr() {
        return str;
    }

    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        StringWrapper sw = new StringWrapper();
        
        int num = sc.nextInt();
        
        sw.setStr(num);
        System.out.println(sw.getStr());
        
        sc.close();
    }
}
