package lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        // (10 + 5 - 3) * 2
        NewIntCalculator intCalc = new NewIntCalculator(10);
        // Trebuie să facem cast la Integer deoarece result() returnează Object
        Integer intResult = (Integer) intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("Rezultat Integer: " + intResult);

        // (10 + 5 - 3.3) * 2.2
        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        Double doubleResult = (Double) doubleCalc.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("Rezultat Double: " + doubleResult);
    }
}