import java.util.Scanner;

class Book extends Product {
    
    int pagecount;

    public Book(int iprice, int ipagecount) {
        super(iprice);
        pagecount = ipagecount;

    }
    public int getPageCount() {
        return pagecount;
    }
}

//*******************************
// DON'T MODIFY THE CLASSES BELOW
//*******************************

class Product {
    private int price;

    public Product(int iprice) {
        price = iprice;
    }

    public int getPrice() {
        return price;
    }
}

public class ProductMain {
    
    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int price = sc.nextInt();
        int pcount = sc.nextInt();
        
        Book potter = new Book(price, pcount);
        System.out.println("Price: " + potter.getPrice() + ", Pagecount: " + potter.getPageCount());
    }
}