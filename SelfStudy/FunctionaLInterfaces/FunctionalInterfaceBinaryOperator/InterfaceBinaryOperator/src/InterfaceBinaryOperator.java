/*                                       №1
 * Создайте реализацию BinaryOperator<String> которая будет возвращать самое
 * длинное слово из двух строк переданных в качестве параметров.
 * */

/*                                       №2
 * Создайте реализацию BinaryOperator<List<Integer>> которая вернет список в котором
 * будут только те элементы которые одновременно присутствуют в первом и во втором
 * списке целых чисел использованных в качестве параметров.
 * */

/*                                       №3
 * Создайте реализацию BinaryOperator<List<T extends Comparable<T>> который будет
 * возвращать список в котором находиться минимальный элемент среди двух списков
 * использованных в качестве параметра. Например для списков [5,0,3,4] и [10,-2, 5]
 * нужно вернуть [10, -2, 5] так как элемент -2 минимален среди элементов этих списков.
 * */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class InterfaceBinaryOperator {

    public static void main(String[] args) {
        BinaryOperator<String> stringBinaryOperator = (stringOne, stringTwo) -> {
            String max = stringOne;
            if (stringOne.length() < stringTwo.length())
                max = stringTwo;
            if (stringOne.length() == stringTwo.length())
                return stringOne + " " + stringTwo;
            return max;
        };

        System.out.println("№1: " + stringBinaryOperator.apply("Hello", "Java"));

        //2
        BinaryOperator<List<Integer>> listBinaryOperator = (listOne, listTwo) -> {
            List<Integer> resultList = new ArrayList<>();

            for (Integer numOne : listOne) {
                if (listTwo.contains(numOne) && !resultList.contains(numOne)) {
                    resultList.add(numOne);
                }
            }

            List<Integer> sunResultList = new ArrayList<>();

            for (Integer num: resultList) {
                if(countInList(listOne, num) > countInList(resultList, num) &&
                countInList(listTwo, num) > countInList(resultList, num)) {

                    int min = countInList(listOne, num);

                    if(countInList(listTwo, num) < min)
                        min = countInList(listTwo, num);

                    for (int i = 0; i < min - 1; i++)
                        sunResultList.add(num);
                }
            }

            resultList.addAll(sunResultList);

            return resultList;
        };

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> integerPrimeList = new ArrayList<>(List.of(2, 3, 7, 11, 13));
        System.out.print("№2: The same in ");
        integerList.forEach(a -> System.out.print(a + " "));
        System.out.print("and ");
        integerPrimeList.forEach(a -> System.out.print(a + " "));
        System.out.print("are ");
        listBinaryOperator.apply(integerList, integerPrimeList).forEach(num -> System.out.print(num + " "));
        System.out.println();

        //3
        System.out.print("№3: The minimum in ");
        integerList.forEach(a -> System.out.print(a + " "));
        System.out.print("and ");
        integerPrimeList.forEach(a -> System.out.print(a + " "));
        System.out.print("are ");
        System.out.println(minElementInTwoListsByNaturalOrder(integerList, integerPrimeList));

        List<String> stringList1 = new ArrayList<>(List.of("aaaa", "bbb"));
        List<String> stringList2 = new ArrayList<>(List.of("aaa", "bbbb"));

        System.out.print("    The minimum in ");
        stringList1.forEach(a -> System.out.print(a + " "));
        System.out.print("and ");
        stringList2.forEach(a -> System.out.print(a + " "));
        System.out.print("are ");
        System.out.println(minElementInTwoListsByNaturalOrder(stringList1, stringList2));
    }

    private static <T> int countInList(List<T> list, T el) {
        int count = 0;
        for (T t: list) {
            if (t.equals(el))
                count++;
        }
        return count;
    }

    private static <T extends Comparable<T>> T minElementInTwoListsByNaturalOrder(List<T> listOne, List<T> listTwo) {
        Comparator<T> comparator = Comparator.naturalOrder();
        BinaryOperator<T> binaryOperator = BinaryOperator.minBy(comparator);

        T min = listOne.get(0);

        for (T el: listOne)
            min = binaryOperator.apply(min, el);

        for (T el: listTwo)
            min = binaryOperator.apply(min, el);

        return min;
    }
}
