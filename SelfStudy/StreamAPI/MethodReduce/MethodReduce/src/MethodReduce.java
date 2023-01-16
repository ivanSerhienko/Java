/*                                             №1
 * Разбейте строку английского текста по символу пробел. Используя reduce верните суммарное
 * количество букв в словах длинна которых превышает 4.
 * */

/*                                             №2
 * Используя reduce верните произведение элементов потока полученных на основании списка целых чисел.
 * */

/*                                             №3
 * Замените с помощью метода reduce терминальный метод max
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MethodReduce {
    public static void main(String[] args) {
        //1
        String string = "Hello Java world";
        int res = Arrays.stream(string.split(" ")).filter(s -> s.length() > 4).
                reduce(0, (num, str) -> str.length() + num, Integer::sum);
        System.out.println("№1: " + string + " - " + res);

        //2
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        int product = list.stream().reduce((num1, num2) -> num1 * num2).get();
        System.out.println("№2: " + product);

        //3
        List<Integer> integers = new ArrayList<>(List.of(13, 4532, 534, 532, 254, 75, 1));
        List<String> strings = new ArrayList<>(
                List.of("So", "we", "need", "new", "stories", "new", "heroes", "and", "new", "tools"));

        System.out.print("№3: ");
        System.out.print(max(0, integers.stream(), Comparator.naturalOrder()) + " ");
        System.out.print(max("", strings.stream(), Comparator.naturalOrder()));
        System.out.println();
    }

    public static <T> T max(T identity, Stream<T> stream, Comparator<? super T> comparator) {
        return stream.reduce(identity, (t1, t2) -> {
            if (comparator.compare(t1, t2) > 0 || comparator.compare(t1, t2) == 0)
                return t1;
            if (comparator.compare(t1, t2) < 0)
                return t2;
            else
                throw new IllegalArgumentException();
        });
    }
}
