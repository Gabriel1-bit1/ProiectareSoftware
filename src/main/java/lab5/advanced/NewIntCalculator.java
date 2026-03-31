package lab5.advanced;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(Integer initialState) {
        this.state = initialState;
    }

    @Override
    public void init() {
        this.state = 0;
    }

    public NewIntCalculator add(Integer value) {
        this.state = (Integer) this.state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        this.state = (Integer) this.state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        this.state = (Integer) this.state * value;
        return this;
    }
}