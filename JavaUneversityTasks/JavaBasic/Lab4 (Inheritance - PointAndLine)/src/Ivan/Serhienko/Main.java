package Ivan.Serhienko;

public class Main {
    public static void main (String [] args){

        Point p1 = new Line(3,3,5,5);
        Line l1 = null;

        if (p1.getClass() ==  Line.class) {
            l1 = (Line)p1;
            l1.getX1();
            System.out.println(((Line) p1).getX1());
        }


        Point point  = new Point(2,5);
        System.out.println(point);

        Line line = new Line(3,3, 5,7);
        System.out.println(line);

        if (point.checkEntryIntoCircle(8, new Point(3,5))) {
            System.out.println("Point enters the circle");
        }


        if (line.checkEntryIntoCircle(8, new Point(3,5))) {
            System.out.println("Line enters the circle");
        }


    }
}
