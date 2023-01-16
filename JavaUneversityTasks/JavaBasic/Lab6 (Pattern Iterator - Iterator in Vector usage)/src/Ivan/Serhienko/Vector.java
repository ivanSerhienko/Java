package Ivan.Serhienko;

import java.util.Arrays;
import java.util.Scanner;

public class Vector {
    private double[] data;
    private int currentSize = 0;

    public Vector(int len) {

        data = new double[len];
        currentSize = len;
    }

    public void inputCoordinate() {
        int var = 0;
        for (int i = 0; i < data.length; i++) {
            Scanner in = new Scanner(System.in);
            var = in.nextInt();
            setCoordinatesInVector(var, i);
        }
    }

    public void setCoordinatesInVector(double data, int i) {
        this.data[i] = data;
    }

    @Override
    public String toString() {
        return "Vector: " +
                Arrays.toString(data);
    }

    class InnerIterator implements Iterator { // внутренний класс

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex <= currentSize - 1;
        }

        @Override
        public double next() {
            return data[currentIndex++];
        }
    }

    public Iterator getAnonymousIterator() { // аннонимный класс
        return new Iterator() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex <= currentSize - 1;
            }

            @Override
            public double next() {
                return data[currentIndex++];
            }
        };
    }

    public Iterator getLocalIterator() {
        class LocalIterator implements Iterator {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex <= currentSize - 1;
            }

            @Override
            public double next() {
                return data[currentIndex++];
            }
        }
        return new LocalIterator();
    }
}
