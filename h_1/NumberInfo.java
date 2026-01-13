import java.util.Scanner;

class NumberInfo{

  private static double avarage(int sum, int n){
    return (double)sum / n;
  }
  public static void main(String args[]){
    int num = 1;
    int sum = 0;
    int n = 0;
    int lowest = Integer.MAX_VALUE;
    int largest = Integer.MIN_VALUE;

    Scanner scanner = new Scanner(System.in);

    while(true){
      System.out.print("Anna pos. kokonaisluku:");
      num = scanner.nextInt();
      if(num < 0){break;}
      largest = Integer.max(largest, num);
      lowest = Integer.min(lowest, num);
      sum += num;
      n++;
    }

    scanner.close();
    double avg = avarage(sum, n);

    System.out.println(
      "Lukum: " + n + "\n" +
      "Keskiarvo: " + avg + "\n" +
      "Suurin: " + largest + "\n" +
      "Pienin: " + lowest + "\n"
    );

  }
}