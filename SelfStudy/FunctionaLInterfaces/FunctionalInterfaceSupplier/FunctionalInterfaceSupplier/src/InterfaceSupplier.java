/*                                              №1
 * Реализуйте с помощью класса Supplier<String> который будет при каждом вызове get()
 * возвращать слово полученное из строки переданной в качестве параметра конструктору этого
 * класса. Для упрощения задания выполните разбиение строки по символу пробел.
 * */

/*                                              №2
 * Реализуйте Supplier<String> с помощью Predicate<String> реализующий следующий функционал:
 * возвращать из List<String> только строки соответствующие реализации Predicate. Например если
 * у вас есть список [«Hello», «world», «Java»], а Predicate возвращает true только если слово
 * начинается с большой буквы, ваша реализация Supplier должна последовательно вернуть
 * «Hello», «Java» и после чего возвращать null (закончились подходящие значения).
 * */

/*                                              №3
 * Реализуйте IntSupplier последовательно возвращающий элемент из массива целых чисел.
 * */

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class InterfaceSupplier {
    public static void main(String[] args) {
        //1
        System.out.println("№1: " + new TaskOne("Hello word !").get());

        //2
        Predicate<String> predicate = string -> Pattern.compile("[A-Z]").matcher(string).find();

        TaskTwo taskTwo = new TaskTwo(List.of("Hello", "world", "Java"), predicate);
        System.out.println("№2: ");
        String result = taskTwo.get();
        while (result != null) {
            System.out.println(result);
            result = taskTwo.get();
        }
    }
}