/*
*                                             1
* С помощью реализации Function<Integer[],Integer> и реализации Predicate<Integer> реализуйте
* функцию которая вернет количество простых чисел в массиве целых чисел.
* Например [5,6,7,8,9,10] => 2
* */

/*
 *                                             2
 * Опишите такую реализацию Function<String, Integer> которая вернет количество согласных букв
 * в строке текста.
 * */

/*
 *                                             3
 * Используя композицию функций реализуйте функцию которая вернет сумму кодов каждого символа
 * в произвольной строке.
 * */

/*
 *                                             4
 * Опишите такую реализацию BiFunction<String,String,String[]> которая вернет в виде массива
 * слова которые одновременно присутствуют и в первой строке и во второй (слова разделены
 * пробелами). Например text1 = «Hello Java», text2 = «Hello Python» в результате должен быть
 * массив вида [«Hello»].
 * */

/*
 *                                             5
 * Используя примитивную специализацию Function реализуйте функционал который на основе
 * объекта типа java.util.Calendar вернет целое число значение которого равно году хранимому в
 * Calendar.
 * */

import java.util.*;
import java.util.function.*;

import static java.math.BigInteger.valueOf;
import static java.lang.Math.log;
import static java.lang.Character.getNumericValue;

public class InterfaceFunction {
    public static void main(String[] args) {
        //1
        Predicate<Integer> predicate = num -> valueOf(num).isProbablePrime((int) log(num));
        Function<Integer[], Integer> func1 = arr -> {
            int amount = 0;
            for (int num: arr)
                if(predicate.test(num) && num > 1)
                    amount++;
            return amount;
        };
        Integer [] arr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ,15, 16, 17, 18, 19, 20};
        System.out.println("№1: amount prime numbers in array: " + func1.apply(arr));

        //2
        Function <String, Integer> func2 = string -> {
            int amount = 0;
            for (int i = 0; i < string.length(); i++)
                if(Character.toString(string.charAt(i)).matches("[aeiou]"))
                    amount++;
            return amount;
        };
        String s = "asdfsgk;;alfh;lsdfgsdgwyqr";
        System.out.println("№2: amount of vowels in string " + func2.apply(s));

        //3
        Function<String, Character []> func3 = string -> {
            Character [] characters = new Character[string.toCharArray().length];
            for (int i = 0; i < string.toCharArray().length; i++)
                characters[i] = string.toCharArray()[i];
            return characters;
        };

        Function<Character[], Integer> func4 = characters -> {
            int sum = 0;
            for (Character c: characters)
                sum += getNumericValue(c);
            return sum;
        };
        Function<String, Integer> func5 = func4.compose(func3);
        System.out.println("№3: sum of characters codes: " + func5.apply(s));

        //4
        BiFunction<String, String, String []> biFunction = (string1, string2) -> {
            String [] arr1 = string1.split(" ");
            String [] arr2 = string2.split(" ");
            List<String> list = new ArrayList<>();
            for (String str1: arr1) {
                for (String str2: arr2) {
                    if(str1.equals(str2))
                        list.add(str2);
                }
            }
            return list.toArray(new String[0]);
        };
        System.out.println("№4: " + Arrays.toString(biFunction.apply("Hello Java", "Hello Python")));

        //5
        Calendar calendar = new GregorianCalendar();
        ToIntFunction<Calendar> toIntFunction = Calendar::getWeekYear;
        System.out.println("№5: " + toIntFunction.applyAsInt(calendar));
    }
}
