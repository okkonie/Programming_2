import java.util.Scanner;

public class IntegerArray {

    static void printArray(int [] arr) {

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String [] args) {

        int nums = 3;
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[nums];

        for (int i = 0; i < nums; i++) {
            System.out.print("Anna luku: ");
            arr[i] = sc.nextInt();
        }

        printArray(arr);

        sc.close();
    }

}
