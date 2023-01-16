// Сергинко Иван лабораторная робота №5
/*Разработать абстрактный класс Figure.  Унаследовать от него классы Rectangle (прямоугольник), Circle (окружность)
  Triangle (треугольник). В классе Rectangle создать метод для вычисления длины диагонали.
  Создать массив  разных фигур и обеспечить вычисление периметра и площади каждой фигуры в зависимости от ее типа.
  А для фигур типа Rectangle также вывести и длину диагонали.*/
package Ivan.Serhienko;

import java.util.Scanner;

public abstract class Figure {
    abstract double perimetr ();
    abstract double square ();
    //double diagonal() {return 0;}
}

class Triangele extends Figure{
    private int a;
    private int b;
    private int c;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Triangele(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimetr () { return a + b +c; }

    @Override
    public double square () {
        int p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    //public double diagonal() {return 0; }
}

class Circle extends Figure {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(int radius) throws Exception {
        if (radius < 0){
            //throw new UnsupportedOperationException("Radius is smaler than 0");
            //Exception ex.getMessage();
            throw new Exception("Radius is smaller than 0");
        }
        this.radius = radius;
    }

    @Override
    public double perimetr(){
        return 2*Math.PI*radius;
    }

    @Override
    public double square(){
        return Math.PI*Math.pow(radius, 2);
    }

    //public double diagonal() {return 0; }
}

class Rectangle extends Figure{
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public double perimetr(){return 2*(a+b);}

    @Override
    public double square(){return a*b;}

    //@Override
    public double diagonal(){return Math.sqrt(Math.pow(a,2) + Math.pow(b,2));}
}
