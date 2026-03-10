package lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Problema {

    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        Random random = new Random();

        //lista x cu 5
        for (int i = 0; i < 5; i++) {
            x.add(random.nextInt(11));
        }

        //lista y cu 7
        for (int i = 0; i < 7; i++) {
            y.add(random.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x (ordonata): " + x);
        System.out.println("Lista y (ordonata): " + y);

        // a) xPlusY conține toate elementele șirurilor x și y
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println("a) xPlusY: " + xPlusY);

        // b) zSet conține numai valorile comune, luate o singură dată
        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) zSet (comune, unice): " + zSet);

        // c) xMinusY conține valorile din x care nu se află în y
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        Collections.sort(xMinusY);
        System.out.println("c) xMinusY (x - y): " + xMinusY);

        // d) xPlusYLimitedByP: elementele din x și y ce nu depășesc p
        // Parcurgem xPlusY (care deja conține x și y și este sortat)
        for (int valoare : xPlusY) {
            if (valoare <= p) {
                xPlusYLimitedByP.add(valoare);
            }
        }
        System.out.println("d) xPlusYLimitedByP (<= " + p + "): " + xPlusYLimitedByP);
    }
}