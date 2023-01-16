/*                                        №1
 * Используя Stream API и List<Cat> верните самое длинное имя кота в этом списке.
 * */

/*                                        №2
 * Используя Stream API и List<Integer> выделите только нечетные числа, отсортируйте их
 * по возрастанию и соберите в новый список.
 * */

/*                                        №3
  * Используя Stream API верните адрес файла с максимальным размером в заданном каталоге.
  * */

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Introduction {
    public static void main(String[] args) {
        //1
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);
        System.out.println("№1: " + list.stream().
                max(Comparator.comparingInt(cat -> cat.getName().length())).
                get().getName());

        //2
        List<Integer> integerList = new ArrayList<>(List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.print("№2: ");
        integerList.stream().
                filter(number -> number % 2 != 0).
                sorted().
                toList().forEach(el -> System.out.print(el + " "));
        System.out.println();

        //3
        System.out.println("№3: " + task3(new File("Folder")));
    }

    private static String task3(File folder) {
        if(folder == null)
            throw new NullPointerException();

        if(folder.listFiles() == null)
            throw new IllegalArgumentException("Empty folder");

        if(folder.isFile())
            throw new IllegalArgumentException("This file, not folder");

        return Arrays.stream(folder.listFiles()).
                max(Comparator.comparingLong(File::length)).
                get().getPath();
    }
}