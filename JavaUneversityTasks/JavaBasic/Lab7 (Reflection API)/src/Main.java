// Сергиенко Иван МФ-21 лабораторная работа №7
/*Протестировать методы рефлексии на типе String:
a)получить объект Class 3 различными способами;
b)вывести все модификаторы класса String;
c)вывести информацию обо всех public конструкторах класса String;
d)вывести информацию обо всех полях класса String;
e)вывести информацию обо всех public методах класса String;
f)вызвать любой из методов и распечатать результат.*/
import java.lang.reflect.*;

public class Main {
    public static void main(String[]args){
        System.out.println("a)"); // Получаем обьект класса 3 способами
        String s1 = new String("hello");
        //System.out.println(s1);
        Class c1 = s1.getClass();
        Class c2 = String.class;
        try { Class c3 = Class.forName("java.lang.String"); }
        catch (ClassNotFoundException e){ System.out.println("Error"); }

        //double d1 = 0;
        Class c4 = double.class;

        System.out.println(c4);


        System.out.println("b)"); // все модификаторы
        int mod = c1.getModifiers();
        if(Modifier.isAbstract(mod))
            System.out.println("Is abstract");
        if(Modifier.isPrivate(mod))
            System.out.println("Is private");
        if(Modifier.isPublic(mod))
            System.out.println("Is public");
        if(Modifier.isProtected(mod))
            System.out.println("Is protected");
        if(Modifier.isFinal(mod))
            System.out.println("Is final");
        if(Modifier.isStatic(mod))
            System.out.println("Is static");
        System.out.println();

        System.out.println("c)"); //public конструторы
        for(Constructor<String> e:c1.getConstructors())
            System.out.println(e);
        System.out.println();

        System.out.println("d)"); //поля
        for(Field e:c1.getFields())
            System.out.println(e);

        System.out.println("e)"); // public методы
        Method[]ms=c1.getMethods();
        for(Method m:ms) {
            int mod1 = m.getModifiers();
            if(Modifier.isPublic(mod1))
                System.out.println(m);
        }

        String a = s1.replace("h","z");
        System.out.println(a);
        System.out.println("f)"); // метод
        try {
            Method method = c2.getMethod("replace", char.class, char.class);
            String rv = (String) method.invoke(s1, 'h','z');
            System.out.println(rv);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
