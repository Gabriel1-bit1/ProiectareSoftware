package lab7;

import lab7.forms.*;
import lab7.util.PasswordMaker;

public class Main {
    public static void main(String[] args) {
        // 7.6.1. Testare contor instanțe
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");

        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);

        // Afișare contor folosind metoda statică
        System.out.println("Total instance count is " + Form.getInstanceCount());

        // 7.6.2. Testare PasswordMaker Singleton
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());

        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());

        // 7.6.2 c) Afișare număr apelări getInstance()
        System.out.println("\n7.6.2 c) Number of times getInstance() has been called: " + PasswordMaker.getCallingCounts());
    }
}