import java.util.Scanner;

public class LetterA {

    static void printLetterA(int n) {
        String As = "";

        if(n < 1){
            System.out.print("Luvun tulee olla suurempi kuin nolla!");
        } else {
          for(int i = 0; i < n; i++){
            As += "A";
          }
          System.out.println(As);
        }
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int a = 0;

        System.out.print("Anna kokonaisluku: ");
        a = sc.nextInt();

        printLetterA(a);

        sc.close();
    }
}