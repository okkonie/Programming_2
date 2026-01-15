import java.util.Scanner;

public class Parenthesis {

    static boolean checkParenthesis(String s) {
        
        boolean isok = false;
        boolean found = true;

        while(found){
          found = false;

          for(int i = 0; i < s.length() - 1; i++){

            if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){

              s = s.substring(0, i) + s.substring(i + 2);

              found = true;
            }
          }
        }
        
        if (s.length() == 0){isok = true;}

        return isok;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        String s;
        boolean isok = false;

        System.out.print("Anna merkkijono: ");
        s = sc.nextLine();

        isok = checkParenthesis(s);

        System.out.println("checkParenthesis(\"" + s + "\"): " + isok);

        sc.close();
    }
}
