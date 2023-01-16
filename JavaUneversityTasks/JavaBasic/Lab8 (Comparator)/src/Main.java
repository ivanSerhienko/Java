// Сергиенко Иван МФ-21 лабораторная работа №8
/*Протестировать ArrayList и TreeSet на задаче хранения объектов классов Point. Для каждой коллекции выполнить следующее:
a)Заполнить коллекцию случайными данными (обеспечить наличие одинаковых элементов).
b)Вывести содержимое коллекции  помощью foreach.
c)Обойти коллекцию с помощью итератора и при обходе удалить все заданные элементы (задать с клавиатуры).
d)Протестировать методы коллекции.
e)Протестировать алгоритмы сортировки и поиска класса Collections.*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("a)");
        System.out.println("ArrayList:");
        Scanner in = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<Point>(100);
        for (int i = 0; i < 10; i++) {
            double x = (int)(Math.random() * 5);
            double y = (int)(Math.random() * 5);
            points.add(new Point(x, y));
        }
        TreeSet<Point> points1 = new TreeSet<Point>(points);
        print(points1);
/*        TreeSet<Point> points2 = new TreeSet<>(new PointComparator());
        points2.addAll(points);
        print(points2);*/
        ArrayList<Point> pointsToDel = new ArrayList<Point>();
        System.out.println("Enter points to remove");
        String end = "";
        while(!end.equals("1")){
            double x = in.nextDouble();
            double y = in.nextDouble();
            pointsToDel.add(new Point(x, y));
            end = in.next();
        }
        System.out.println("c)");
        Iterator<Point> pointIterator = points.iterator();
        while (pointIterator.hasNext()) {
            Point p = pointIterator.next();
            if(pointsToDel.contains(p)) {
                pointIterator.remove();
            }
        }
        print(points);
        System.out.println();
        System.out.println("d)");
        print(points.subList(3, 5));

        points.sort(new PointComparator());
        print(points);

        System.out.println("TreeSet");
        print(points1);
        Iterator<Point> pointTreeIterator = points1.iterator();
        while (pointTreeIterator.hasNext()){
            Point p = pointTreeIterator.next();
            if(pointsToDel.contains(p)){
                pointTreeIterator.remove();
            }
        }
        System.out.println(points1.pollLast());
    }

    //b)
    static public <E> void print(Collection<E> col)
    {
        System.out.println();
        for(E elem : col){
            System.out.println(elem);
        }
    }
}