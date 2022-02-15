package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("Maxim");

    double len = 5;
    System.out.print("Площадь квадрата о со стороной " + len + " = " + area(len));

    double a = 4;
    double b = 6;
    System.out.print("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));
  }

  public static void hello (String sambody) {
     System.out.println("Hello, " + sambody + "!");
  }

  public static double area (double l) {
    return l * l;
  }
  public static double area (double a, double b) {
    return a * b;
  }
}
