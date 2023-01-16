/*                                        №1
 * С помощью реализации Comparator<Cat> отсортируйте массив Cat в порядке возрастания
 * длинны имени. Т.е. сначала должны идти коты чье имя самое короткое.
 * */

/*                                        №2
 * Используя составной Comparator реализуйте в List<Integer> поиск числа модуль которого
 * наиболее близок к нулю. Если встретятся два модуль которых одинаково близок к нулю(например
 * 5 и -5) то верните положительное значение.
 * */

/*                                        №3
 * Создайте реализацию Comparator<Integer> для сортировки списка целых чисел. Но сравнение
 * должно выполняться на основание суммы первой и последней цифры числа. Т.е например список
 * чисел подобного вида [62,2000,306,55] должен быть отсортирован как [2000, 62, 306,55].
 * */

/*                                        №4
 * Создайте такую реализацию Comparator<Integer> что бы с ее помощью можно было найти
 * максимальное простое число в списке целых чисел, если такого числа в списке нет то должно
 * быть возвращено минимальное число.
 * */

/*                                        №5
 * Создайте Comparator<File> для сортировке списка текстовых файлов по количеству знаков
 * препинания в них. При решении принять, что знаки препинания ограниченны символами {, . - ? !}
 * и символ пробел.
 * */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.lang.Math.log;
import static java.math.BigInteger.valueOf;

public class FunctionalInterfaceComparator {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 5);
        Cat cat5 = new Cat("Kuzia", 2);
        Cat[] cats = new Cat[] { cat1, cat2, cat3, cat4, cat5 };

        //1
        Comparator<Cat> comparator1 = comparingInt(a -> a.getName().length());
        Arrays.sort(cats, comparator1);
        System.out.print("№1: ");
        printArr(cats);

        //2
        Comparator<Integer> comparator2_1 = comparingInt(Math::abs);
        Comparator<Integer> comparator2_2 = (a, b) -> b - a;
        Comparator<Integer> comparator2_3 = comparator2_1.thenComparing(comparator2_2);

        List<Integer> integerList = new ArrayList<>(List.of(-4, -1, 5 , 2, -2, 1, -5, 4));
        integerList.sort(comparator2_3);
        System.out.println("№2 " + integerList);

        //3
        integerList = new ArrayList<>(List.of(62, 2000, 306, 55));

        Comparator<Integer> comparator3 = (a, b) -> {
            char[] charArrayOfNumA = a.toString().toCharArray();
            char[] charArrayOfNumB = b.toString().toCharArray();
            return  (charArrayOfNumA[0] + charArrayOfNumA[charArrayOfNumA.length-1]) -
                    (charArrayOfNumB[0] + charArrayOfNumB[charArrayOfNumB.length-1]);
        };

        integerList.sort(comparator3);
        System.out.println("№3: " + integerList);

        //4
        integerList = new ArrayList<>(List.of(11, 4, 22, 17, 8, 9));
        List<Integer> secondIntegerList = new ArrayList<>(List.of(10, 4, 22, 16, 8, 9));

        Comparator<Integer> comparator4 = (a, b) -> {
            if(valueOf(a).isProbablePrime((int) log(a))) {
                if(valueOf(b).isProbablePrime((int) log(b)))
                    return a - b;
                return a;
            }
            return b - a;
        };

        System.out.println("№4: " + integerList + " " + integerList.stream().max(comparator4).get());
        System.out.println("    " + secondIntegerList + " " + secondIntegerList.stream().max(comparator4).get());

        //5
        List<File> fileList = new ArrayList<>(List.of(new File("FileOne"), new File("FileTwo"),
                new File("FileThree"), new File("FileFour")));

        Comparator<File> comparator5 = comparingInt(FunctionalInterfaceComparator::amountOFPunctuationMarksInFile);

        System.out.println("№5: before sort - " + fileList);
        fileList.sort(comparator5);
        System.out.println("     after sort - " + fileList);
    }
    private static int amountOFPunctuationMarksInFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int count = 0;
            int i;
            while ((i = fileInputStream.read()) != -1){
                if((char) i == '?' || (char) i == ',' || (char) i == '.' || (char) i == '-' || (char) i == '!')
                    count++;
            }
            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> void printArr (T [] arr) {
        for (T el: arr)
            System.out.print(el + " ");
        System.out.println();
    }
}
