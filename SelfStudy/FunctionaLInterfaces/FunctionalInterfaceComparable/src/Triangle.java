import java.util.Objects;

public class Triangle implements Comparable<Triangle>{
    private int length;
    private int height;

    public Triangle(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double square() {
        return 0.5 * this.length * this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return length == triangle.length && height == triangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "length=" + length +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Triangle o) {
        return (int) (this.square() - o.square());
    }
}
