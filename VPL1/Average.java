import java.util.Scanner;

public class Average {

    static double average(double [] arr) {
        
        double avrg = 0.0;
        int len = arr.length;

        for(int i = 0; i < len; i++){
          avrg += arr[i];
        }

        avrg /= len;

        return avrg;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        double [] arr = new double[4];
        double avrg = 0;

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter number > ");
            arr[i] = sc.nextDouble();
        }

        avrg = average(arr);
        System.out.println(avrg);

        sc.close();
    }
}
