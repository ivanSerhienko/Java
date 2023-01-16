/*
 *                                               №1
 * С помощью реализации Predicate<String> реализуйте удаление со списка строк начинающихся с определенной буквы.
 * Например удалить все строки которые начинаются на букву F.
 * */

/*
 *                                               №2
 * Используя реализацию Predicate<String> реализуйте удаление со списка строк, строки первая буква которых задается
 * отдельным массивом символов. Например если этот массив содержит ['h', 'a', t] то со списка стоит удалить все
 * строки которые начинаются с этих букв
 * */

/*
 *                                               №3
 * Используя реализацию Predicate<Cat> (в качестве Cat взять класс испльзуемый в лекции) и методы для логических
 * функий, реализуйте удаление из списка Cat котов возраст которых меньше определенного значения (задается как
 * параметр), а имя по алфавиту идет после буквы (задается как параметр). Например если первый параметр задан как 5,
 * а второй как 'C' то будет удален Cat[name=Timka, age=4], Cat [name=Kuiza, age = 2].
 * */

/*
 *                                               №4
 * Используя реализацию BiPredicate<Integer, String> реализуйте удаление из Map<Integer, String>
 * всех пар ключ-значение для которых длинна строки значения не равна ключу этого значения.
 * Например такая пара как {3: «Hello»} должна быть удалена так как длинна «Hello» не равна 3, а
 * пара вида {4: «Java»} останется.
 * */

/*
 *                                              №5
 * Создайте такую реализацию IntPredicate которая будет возвращать true в случае когда сумма
 * цифр числа число четное. Например для 103 — вернет true, так 1+0+3 = 4.
 * */
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten"));

        // 1
        one(list, 's');

        System.out.print("№1: ");
        for (String s: list)
            System.out.print(s + " ");
        System.out.println();

        //2
        list = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten"));
        two(list, 't', 'f', 's');

        System.out.print("№2: ");
        for (String s: list)
            System.out.print(s + " ");
        System.out.println();

        //3
        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 4);
        Cat cat5 = new Cat("Kuzia", 2);
        List<Cat> cats = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));
        three(cats, 5, 'C');

        System.out.print("№3: ");
        for (Cat cat: cats)
            System.out.print(cat + " ");
        System.out.println();

        //4
        Map<Integer, String> map = new HashMap<>(Map.of(3, "Hello", 4, "Java"));
        four(map);

        System.out.print("№3: ");
        for (Map.Entry<Integer, String> entry: map.entrySet())
            System.out.print(entry + " ");
        System.out.println();

        //5
        System.out.println("№5: for 103 - " + five(103) + ", for 104 - " + five(104));
    }
    private static void one(List<String> list, char c) {
        list.removeIf(word -> word.startsWith(Character.toString(c)));
    }

    private static void two(List<String> list, char ... chars) {
        Predicate<String> predicate = word -> {
            for (char c: chars)
                if (word.startsWith(Character.toString(c)))
                    return true;
            return false;
        };
        list.removeIf(predicate);
    }

    private static void three(List<Cat> list, int age, char c) {
        Predicate<Cat> predicate = cat -> cat.getAge() < age &&
                cat.getName().compareTo(Character.toString(c)) > 0;

        list.removeIf(predicate);
    }

    private static void four (Map <Integer, String> map) {
        //BiPredicate<Integer, String> predicate = (num, word) -> word.length() != num;
        map.entrySet().removeIf(entry -> entry.getKey() != entry.getValue().length());
    }

    private static boolean five (int number) {
        IntPredicate predicate = num -> {
            int sum = 0;
            while(num != 0){
                sum += (num % 10);
                num/=10;
            }
            return sum % 2 == 0;
        };
        return predicate.test(number);
    }
}