import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Printable printable = new Main()::sum;
        //System.out.println(printable.mod());
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);

        for (Map.Entry <Integer, Integer> entry: map.entrySet())
            System.out.println(entry);
    }

    public int sum() {return 1;}
}