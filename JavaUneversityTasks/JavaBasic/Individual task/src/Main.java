/*Шевченко Виктории
Разработать набор классов любой предметной области.
Обеспечить наличие классов, связанных иерархией наследования.
Обеспечить реализацию основной функциональности предметной области.
Разработать класс/классы для тестирования/демонстрации основной функциональности.*/

import java.util.Scanner;

public class Main {
    public static void main (String [] Args) {
        Restaurant res = new Restaurant("Poura de la Krusha", 6, 12, 6);
        res.modularity();
        Hall hall = new Hall();
    }
}
