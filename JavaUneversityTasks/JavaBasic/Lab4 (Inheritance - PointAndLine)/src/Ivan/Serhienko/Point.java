//Сергиенко Иван МФ-21 лабораторная работа №4
/*Разработать класс, производный от класса Point. Протестировать полиморфное связывание.*/

package Ivan.Serhienko;

public class Point {
    private int x0;
    private int y0;

    public Point(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public void setX0(int x) {
        this.x0 = x;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    @Override
    public String toString() {
        return "Point (" +
                x0 +
                "," + y0 +
                ')';
    }

    public boolean checkEntryIntoCircle(int r, Point p) {
        return this.x0 < p.x0 + r && this.x0 > p.x0 - r && this.y0 < p.y0 + r && this.y0 > p.y0 - r;
    } // точка и радиус
}

class Line extends Point {

    private int x1;
    private int y1;

    public Line(int x0, int y0, int x1, int y1) {
        super(x0, y0);
        this.x1 = x1;
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public String toString() {
        return "Line (" +
                getX0() + "," +
                getY0() + "," +
                x1 + "," +
                y1 +
                ')';
    }

    @Override
    public boolean checkEntryIntoCircle(int r, Point p) {
        return getX0() < p.getX0() + r && this.getX0() > p.getX0() - r && this.getY0() < p.getY0() + r && this.getY0() > p.getY0() - r
                && this.x1 < p.getX0() + r && this.x1 > p.getX0() - r && this.y1 < p.getY0() + r && this.y1 > p.getY0() - r;
    } // точка и радиус
}