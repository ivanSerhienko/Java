/*                                          №1
 * С помощью реализации UnaryOperator замените все нечетные числа в списке целых
 * чисел на нули.
 * */

/*                                          №2
 * Создайте реализацию UnaryOperator<String> где результатом будет строка в которой
 * исключены все символы кроме цифровых. Т.е. если входящим параметром является
 * строка вида «Hello 123 world» результатом будет строка «123».
 * */

/*                                          №3
 * Создайте реализацию UnaryOperator<List<String>> где результатом будет список строк
 * (созданный на основе списка выступающего в качестве параметра) длинна которых
 * больше 5 символов.
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class InterfaceUnaryOperator {
    public static void main(String[] args) {
        //1
        UnaryOperator<Integer> integerUnaryOperator = number -> {
            if(number % 2 != 0) {
                return  0;
            }
            return number;
        };

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println("№1");

        integerList.forEach(a -> System.out.print(a + " "));
        integerList.replaceAll(integerUnaryOperator);

        System.out.println();

        integerList.forEach(a -> System.out.print(a + " "));

        System.out.println();

        //2
        UnaryOperator<String> stringUnaryOperator = string -> {
            StringBuilder stringBuilder = new StringBuilder();
            char [] chars = string.toCharArray();
            for (char c: chars) {
                if(isDigit(c))
                    stringBuilder.append(c);
            }
            return stringBuilder.toString();
        };

        String s = "Hello 123 world";
        System.out.println("№2: " + stringUnaryOperator.apply(s));

        //3
        UnaryOperator<List<String>> listUnaryOperator = list -> {
            List<String> resultList = new ArrayList<>();
            for (String string: list) {
                if(string.length() > 5)
                    resultList.add(string);
            }
            return resultList;
        };

        List<String> stringList = new ArrayList<>(List.of("Hello", "my", "favorite", "student"));
        System.out.print("№3: ");
        listUnaryOperator.apply(stringList).
                forEach(string -> System.out.print(string + " "));
        System.out.println();
    }

    private static boolean isDigit(char c) {
        return Character.toString(c).matches("[1-9]");
    }
}