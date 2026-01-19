import java.util.Scanner;

public class TimeAMPM {

    static String convertTime(String s) {

        String time24 = "";

        boolean isAM = s.substring(6,8).equals("AM");
        
        String hourString = s.substring(0,2);
        int hours = Integer.parseInt(hourString);

        if(hours == 12){hours = 0;} 
        if(!isAM){hours += 12;}

        if(hours < 10){time24 += "0";}
        time24 += Integer.toString(hours);
        time24 += s.substring(2,5);

        return time24;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        String s, ss;

        System.out.print("Anna aika: ");
        s = sc.nextLine();

        ss = convertTime(s);
        System.out.println(ss);

        sc.close();
    }
}