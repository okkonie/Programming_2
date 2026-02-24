import java.util.Scanner;

public class AgeException {
  
    public class NegativeAgeException extends Exception {
        public NegativeAgeException(String message){
            super(message);
        }
    }

    static class Person {
        
        private String name;
        private int age;

        public Person(String iname, int iage) throws NegativeAgeException {
            name = iname;
            age = iage;
        }

        public String getName() {
            return name;
        }

        public void setName(String nname) {
            name = nname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int nage) throws NegativeAgeException {
            if(age < 0){
                throw new NegativeAgeException("Negative age not allowed");
            }
            age = nage;
        }
    }
    
    /**
     * DO NOT MODIFY THE MAIN METHOD !!!
     */
    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();
        Person human = null;
        
        try {
            human = new Person(name, age);
        }
        catch (NegativeAgeException e) {
            System.out.println(e.getMessage() + ": " + age);
        }       
        if (human != null)
        System.out.println(human.getName() + ": " + human.getAge());
        
        sc.close();
    }
}