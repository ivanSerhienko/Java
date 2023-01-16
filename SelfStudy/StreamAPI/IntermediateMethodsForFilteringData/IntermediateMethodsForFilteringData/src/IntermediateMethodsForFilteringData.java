/*                                        №1
 * Удалите из строки текста все слова длиннее 4 символов.
 * */

/*                                        №2
 * Удалите из строки символы которые не являются буквами английского алфавита.
 * */

/*                                        №3
 * Удалите из List<Cat> всех кошек вес которых меньше 3 кг, отсортируйте их по именам (в
 * лексикографическом порядке) и соберите результат в новый список Cat.
 * */

/*                                        №4
 * Ниже приведен фрагмент XML документа (pom.xml — используется в Maven для указания зависимостей)
 *    <dependency>
 *        <groupId>junit</groupId>
 *        <artifactId>junit</artifactId>
 *        <version>4.4</version>
 *        <scope>test</scope>
 *    </dependency>
 *    <dependency>
 *        <groupId>org.powermock</groupId>
 *        <artifactId>powermock-reflect</artifactId>
 *        <version>3.2</version>
 *    </dependency>
 * Поместите эти строки в массив строк, создайте поток на его основе и выделите значения в теге <groupid> и
 * соберите результат в список строк.
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class IntermediateMethodsForFilteringData {
    public static void main(String[] args) {
        //1
        String string1 = "Hello Java world";
        System.out.print("№1: ");
        Arrays.stream(string1.split(" ")).
                filter(str -> str.length() < 5).
                toList().forEach(s -> System.out.print(s + " "));

        System.out.println();

        //2
        String string2 = "asdf1234";
        Character [] character = new Character[string2.toCharArray().length];
        for (int i = 0; i < character.length; i++)
            character[i] = string2.toCharArray()[i];

        System.out.print("№2: ");
        Arrays.stream(character).
                filter(c-> Pattern.matches("[a-zA-Z]", c.toString())).
                toList().forEach(System.out::print);
        System.out.println();

        //3
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 1, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        List<Cat> cats = new ArrayList<>(List.of(cat1, cat2, cat3, cat4));
        System.out.print("№3: ");
        cats.stream().filter(cat -> cat.getWeight() < 3).
                sorted(Comparator.comparing(Cat::getName)).
                toList().forEach(cat -> System.out.print(cat + " "));
        System.out.println();

        //4
        String string = "<dependency>\n" +
                "<groupId>junit</groupId>\n" +
                "<artifactId>junit</artifactId>\n" +
                "<version>4.4</version>\n" +
                "<scope>test</scope>\n" +
                "</dependency>\n" +
                "<dependency>\n" +
                "<groupId>org.powermock</groupId>\n" +
                "<artifactId>powermock-reflect</artifactId>\n" +
                "<version>3.2</version>\n" +
                "</dependency>";

        Arrays.stream(string.split("\n")).
                filter(s -> Pattern.compile("<groupId>").matcher(s).find()).
                map(s -> s.substring(9).split("<")[0]).
                toList().forEach(s -> System.out.print(s + " "));
    }
}