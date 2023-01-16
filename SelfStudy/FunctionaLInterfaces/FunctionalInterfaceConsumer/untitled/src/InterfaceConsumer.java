/*                                         №1
 * Реализуйте Consumer<Integer> с помощью которого выведите на экран все нечетные
 * числа содержащиеся в List<Integer>.
 * */

/*                                         №2
 * Реализуете Consumer<String> с побочным эффектом в виде занесения всех строк
 * содержащих цифры во вспомогательный список.
 * */

/*                                         №3
 * Реализуйте BiConsumer<String, File> добавляющий строку в конец файла указанного в
 * качестве параметра.
 * */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class InterfaceConsumer {
    public static void main(String[] args) {
        //1
        Consumer<Integer> consumer1 = a -> {
            if (a % 2 == 0)
                System.out.print(a + " ");
        };
        List<Integer> integerList = new ArrayList<>(List.of(1, 2 ,3, 4, 5, 6, 7, 8, 9, 10));
        System.out.print("№1: ");
        integerList.forEach(consumer1);
        System.out.println();

        //2
        List<String> stringList = new ArrayList<>(
                List.of("1", "two", "3", "four", "5", "six", "7", "eight", "9", "ten"));
        List<String> subStringList = new ArrayList<>();
        Consumer<String> consumer2 = a -> {
            for (int i = 1; i < 10; i++) {
                if(a.contains(Integer.toString(i))) {
                    subStringList.add(a);
                    break;
                }
            }
        };
        stringList.forEach(consumer2);
        System.out.print("№2: ");
        for (String s: subStringList)
            System.out.print(s + " ");
        System.out.println();

        //3
        File file = new File("File");
        BiConsumer<String, File> biConsumer = (s, f) -> {
            try {
                Files.write(Paths.get(f.getPath()), s.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        biConsumer.accept("1!", file);
    }
}
