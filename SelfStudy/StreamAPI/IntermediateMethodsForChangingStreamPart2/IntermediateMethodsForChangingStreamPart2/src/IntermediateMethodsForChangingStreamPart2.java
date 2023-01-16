/*                                     №1
 * Разбейте строку английского текста по символу пробел. Полученный набор слов отсортируйте в
 * порядке возрастания количества гласных букв в нем. Слова в которых нет гласных букв стоит
 * исключить из результата.
 * */

/*                                     №2
 * Из списка котов выберите котов вес которых больше 5, и отсортируйте их по кличке. Результат поместите в список.
 * */

/*                                     №3
 * Из списка целых чисел, выделите те значения которых больше 10, отсортируйте по значению
 * последней цифры результат выведите на экран.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.BaseStream;

public class IntermediateMethodsForChangingStreamPart2 {
    public static void main(String[] args) {
        //1
        String string = "Hello Java ! jjjj";

        System.out.print("№1: ");
        Arrays.stream(string.split(" ")).filter(s ->amountVowels(s) != 0).
                sorted(Comparator.comparingInt(IntermediateMethodsForChangingStreamPart2::amountVowels)).
                toList().forEach(s -> System.out.print(s + " "));
        System.out.println();

        //2
        Cat cat1 = new Cat("Luska", 2, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 6, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> cats = List.of(cat1, cat2, cat3, cat4);
        cats.stream().filter(cat -> cat.getWeight() > 5).
                sorted(Comparator.comparing(Cat::getName)).
                toList().forEach(cat -> System.out.print(cat.getName() + " "));

        System.out.println();
        //3
        List<Integer> list = new ArrayList<>(List.of(19, 4, 52, 43, 77, 30, 2, -56, 123));
        System.out.println(getLastDigitInNum(44));

        list.stream().filter(num -> num > 10).
                sorted(Comparator.comparing(IntermediateMethodsForChangingStreamPart2::getLastDigitInNum)).
                toList().forEach(num -> System.out.print(num + " "));
    }

    private static int amountVowels(String string) {
        int amount = 0;
        for (char c: string.toCharArray()) {
            if(Character.toString(c).matches("[euioa]"))
                amount++;
        }
        return amount;
    }

    private static int getLastDigitInNum(int num) {
        char [] chars = Integer.toString(num).toCharArray();
        return Integer.parseInt(Character.toString(chars[chars.length - 1]));
    }
}