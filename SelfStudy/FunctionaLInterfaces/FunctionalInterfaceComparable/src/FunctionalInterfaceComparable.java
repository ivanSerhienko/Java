/*                                           №1
 * Создайте класс прямоугольник, с двумя полями - длинной и высотой прямоугольника. Задайте
 * отношение естественного порядка для объектов этого класса (реализуйте интерфейс Comparable)
 * на основании площади этого прямоугольника. Используйте эту реализацию для сортировки массива
 * объектов класса прямоугольник.
 * */

/*                                           №2
 * Реализуйте обобщенный метод поиска максимального элемента в массиве объектов. Для этого
 * укажите ограничение для параметра типа этого метода как Comparable<T>. Сигнатура такого
 * метода должна выглядеть следующим образом: <T extends Comparable<T>> T max(T[] array)
 * */

/*                                           №3
 * Установите отношение естественного порядка для класса Cat на основании длинны имени. Т.е. чем
 * длиннее имя тем больше объект. Ваша реализация Comparable<Cat> должна быть совместима с
 * отношением эквивалентности (метод equals при необходимости можете также заменить).
 * */

import java.util.Arrays;

public class FunctionalInterfaceComparable {
    public static void main(String[] args) {
        //1
        Triangle [] triangles = new Triangle[] {new Triangle(2, 6), new Triangle(4, 2),
                new Triangle(2, 3)};
        Arrays.sort(triangles);
        System.out.print("№1: ");
        printArr(triangles);

        //2
        System.out.println("№2: " + max(triangles));

        //3
        Cat [] cats = new Cat[] {new Cat("Umka", 12), new Cat("Luska", 5),
                new Cat("Kuzia", 2), new Cat("Umka", 12), new Cat("Barsic", 12)};

        Arrays.sort(cats);
        System.out.print("№3: ");
        printArr(cats);
    }

    private static <T> void printArr(T [] arr) {
        for (T el: arr)
            System.out.print(el + " ");
        System.out.println();
    }

    private static <T extends Comparable<T>> T max(T[] array) {
        if(array == null)
            return null;

        if(array.length == 0)
            return null;

        T max = array[0];
        for (T el: array) {
            if(el.compareTo(max) > 0)
                max = el;
        }

        return max;
    }
}