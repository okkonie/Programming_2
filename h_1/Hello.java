import java.util.Scanner;

class Hello{
  public static void main(String args[]){
    
    Scanner obj = new Scanner(System.in);
    System.out.print("Anna nimesi: ");

    String name = obj.next();
    obj.close();

    System.out.println("Tervetuloa Java-ohjelmoinnin maailmaan " + name);
  }

} 