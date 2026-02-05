import java.util.Scanner;

public class IntegerPoint {

    private IntegerValue x;
    private IntegerValue y;

   static class IntegerValue {
      int num;

      IntegerValue(int num){
        this.num = num;
      }

      public int getInt() {
        return num;
      }

      public void add(int num){
        this.num += num;
      }
    }

    public IntegerValue getX() {
      return x;
    }

    public IntegerValue getY() {
      return y;
    }

    public IntegerPoint(IntegerValue x, IntegerValue y){
      this.x = x;
      this.y = y;
    }

    public IntegerPoint add(IntegerPoint inpt){
      IntegerValue x = new IntegerValue(this.x.getInt());
      IntegerValue y = new IntegerValue(this.y.getInt());
      x.add(inpt.x.getInt());
      y.add(inpt.y.getInt());

      return new IntegerPoint(x, y);
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        // Values for the integer points
        int num1 = sc.nextInt();
        IntegerValue intv1 = new IntegerValue(num1);
        int num2 = sc.nextInt();
        IntegerValue intv2 = new IntegerValue(num2);
        int num3 = sc.nextInt();
        IntegerValue intv3 = new IntegerValue(num3);
        int num4 = sc.nextInt();
        IntegerValue intv4 = new IntegerValue(num4);
        
        IntegerPoint intp = new IntegerPoint(intv1, intv2);
        IntegerPoint intp2 = new IntegerPoint(intv3, intv4);

        // Add the valuesof the second point to the first point
        intp = intp.add(intp2);

        System.out.println("x = " + intp.x.num + ", y = " + intp.y.num);
        
        sc.close();
    }
}
