import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        System.out.println("Comporator");
        if(p1.getX() < p2.getX() || (p1.getX() == p2.getX() && p1.getY() < p2.getY())) { return -1; }
        else if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) { return 0; }
        return 1;
    }
}
