package Ivan.Serhienko;

public class Main {
    public static void main (String [] Args) throws Exception{

        Figure [] figures =  {new Circle(5), new Rectangle(3,4), new Triangele(5,6,7) };

        System.out.println("Area");
        for(Figure i : figures){
            System.out.print(i.square() + " | ");
        }

        System.out.println();

        System.out.println("Perimetr");
        for(Figure i : figures){
            System.out.print(i.perimetr() + " | ");
        }

        System.out.println();

        System.out.println("Diagonal");
        //for(Figure i : figures){
        //    if (i.getClass() == Rectangle.class) {
        //        System.out.println(i.diagonal());
        //    }
        //}

        // downcast with instanceof
        Figure test = new Rectangle(2,3);
        Rectangle rectangle = null;
        if(test instanceof Rectangle){
            rectangle = (Rectangle) test;
        }
        System.out.println(((Rectangle) test).diagonal());
    }
}
