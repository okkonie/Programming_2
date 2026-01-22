import java.util.Scanner;

public class NumOfColumns {
    
    static boolean hasEqualColumnWidth(String s) {
        int cols = numOfExpectedColumns(s);
        
        String[] rows = s.split("\n");  

        if (rows.length < 2) {return false;}
        
        for(int i = 1; i < rows.length; i++){
            if(cols != rows[i].split(",").length){
                return false;
            }
        }

        return true;
    }
    
    static int numOfExpectedColumns(String s) {
        String firstRow = s.split("\n")[0];
        
        return firstRow.split(",").length;
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        String s = "";
        boolean isok = false;

        System.out.print("Anna kokonaisluku: ");
        choice = sc.nextInt();

        switch (choice){
            case 1:
            s = "this\n";
            break;
            case 2:
            s = "this,asd\nthis";
            break;
            case 3:
            s = "this,asd\nasd,this";
            break;
            case 4:
            s = "this,hello,true \nthis, hello, false\nthis,lucky,false \n hello, false,this";
            break;
        }

        isok = hasEqualColumnWidth(s);
        int cols = numOfExpectedColumns(s);
        
        System.out.print("Jokaisella rivillä " + cols + " saraketta: ");
        String status = isok ? "TRUE" : "FALSE";
        System.out.println(status);

        sc.close();
    }
}
