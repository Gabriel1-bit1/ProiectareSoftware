package lab5.calculator;

public class IntCalculator {
    // Folosim protected pentru a permite accesul în clasa derivată (AdvancedCalculator)
    protected int state;

    public IntCalculator(int initialState) {
        this.state = initialState;
    }

    public IntCalculator add(int value) {
        this.state += value;
        return this; // Returnăm obiectul curent pentru chaining
    }

    public IntCalculator subtract(int value) {
        this.state -= value;
        return this;
    }

    public IntCalculator multiply(int value) {
        this.state *= value;
        return this;
    }

    public int result() {
        return this.state;
    }

    public void clear() {
        this.state = 0;
    }
}