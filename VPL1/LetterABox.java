import java.util.Scanner;

public class LetterABox {
    
    static void printBox(int n, int m)
    { 
        if(n < 1 || m < 1){
          System.out.println("Tarkista antamasi arvot!");
        } else {
          String As = "" ;

          for(int i = 0; i < m; i++){
            As += "A";
          }

          for(int j = 0; j < n; j++){
            System.out.println(As);
          }
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;

        System.out.print("Anna kokonaisluku: ");
        a = sc.nextInt();
        
        System.out.print("Anna kokonaisluku: ");
        b = sc.nextInt();

        printBox(a, b);

        sc.close();
    }
}
