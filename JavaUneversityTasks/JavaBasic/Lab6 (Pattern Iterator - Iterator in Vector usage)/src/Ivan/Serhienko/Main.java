package Ivan.Serhienko;

import java.util.Scanner;

public class Main {
    public  static void main (String [] Args){
        System.out.print("Enter length of vector: ");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        Vector vector1 = new Vector(length);
        System.out.println("Enter coordinates: ");
        vector1.inputCoordinate();

        System.out.println(vector1);

        System.out.println("Inner class");

        // Inner class
        Vector.InnerIterator inner = vector1.new InnerIterator();
        System.out.println(inner.hasNext());
        System.out.println(inner.next());
        System.out.println(inner.next());


        System.out.println("Anonymous class");

        //Anonymous class
        Iterator anonymous = vector1.getAnonymousIterator();
        System.out.println(anonymous.hasNext());
        System.out.println(anonymous.next());
        System.out.println(anonymous.next());

        System.out.println("Local class");
        //Local class
        Iterator local = vector1.getLocalIterator();
        System.out.println(local.next());
        System.out.println(local.hasNext());
        System.out.println(local.next());
    }
}
