import java.util.Scanner;

public class Minimum {

    static int getMinimum(int[] arr) {
        
        int min = Integer.MAX_VALUE;
    
        for(int i = 0; i < arr.length; i++){
          if(arr[i] < min){
            min = arr[i];
          }
        }
    
        return min;
    }

    public static void main(String [] args) {

        int nums = 5;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[nums];
        int min = 0;

        for (int i = 0; i < nums; i++) {
            System.out.print("Anna luku: ");
            arr[i] = sc.nextInt();
        }

        min = getMinimum(arr);
        System.out.println(min);

        sc.close();
    }
}
