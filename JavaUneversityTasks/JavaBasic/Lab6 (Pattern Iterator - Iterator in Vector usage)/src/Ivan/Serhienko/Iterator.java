// Сергиенко Иван МФ-21
/*Разработать интерфейс Iterator. Реализовать его разными способами, в том числе с помощью внутренних классов,
  безымянных внутренних классов, локальных внутренних классов. Сравнить реализации интерфейса и выбрать наиболее подходящий способ.
  Выбор обосновать.
 */

package Ivan.Serhienko;

public interface Iterator{
    boolean hasNext(); // возвращает true если есть еще элементы

    double next(); // возврощает следуйщий элемент
}