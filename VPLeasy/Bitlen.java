import java.util.Scanner;

public class Bitlen {

    static int bitLen(int n) {
        int bits = 1;
        int i = 2;
        
        if(n < 0){return -1;}
        
        while(true){
            if(n < i){
                break;
            }
            i *= 2;
            bits++;
        }
        
        return bits;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int a = 0;
        int bits = 0;

        System.out.print("Anna kokonaisluku: ");

        a = sc.nextInt();
        
        bits = bitLen(a);
        
        if(bits == -1){
            System.out.print("Virheellinen arvo!");
        } else{
            System.out.print(bits);
        }
        
        sc.close();
    }
}