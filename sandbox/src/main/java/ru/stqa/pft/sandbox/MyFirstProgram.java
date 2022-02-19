package ru.stqa.pft.sandbox;

import java.awt.*;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello( "user");
    hello("Maxim");

    Square s = new Square(5);
    System.out.print("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.print("Площадь прямоугольника со сторонами " + r.x + " и " + r.y + " = " + r.area());
  }

  public static void hello (String sambody) {
     System.out.println("Hello, " + sambody + "!");
  }

}
