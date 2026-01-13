import java.util.Scanner;

class Hello{

  public static void main(String args[]){
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Anna nimesi: ");

    String name = scanner.nextLine();

    System.out.println("Tervetuloa Java-ohjelmoinnin maailmaan " + name);
    
    scanner.nextLine();
    scanner.close();
  }

} 