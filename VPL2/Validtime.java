import java.util.Scanner;

public class Validtime {
    
    static boolean isValidTime(String s){
    
      boolean isvalid = true;

      String[] arr = s.split(":");

      int hours = Integer.parseInt(arr[0]);
      int mins = Integer.parseInt(arr[1]);

      if(hours < 0 || hours > 23){
        isvalid = false;
      }

      if(mins < 0 || mins > 59){
        isvalid = false;
      }
      
      return isvalid;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s;
        boolean isok = false;

        System.out.print("Anna aika (hh:mm): ");
        s = sc.nextLine();

        isok = isValidTime(s);
        System.out.println(isok);

        sc.close();
    }

}
