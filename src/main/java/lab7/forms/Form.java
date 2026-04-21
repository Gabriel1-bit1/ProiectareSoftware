package lab7.forms;

public class Form {
    private String color;
    // 7.6.1: Câmp static pentru numărarea instanțelor
    private static int counter = 0;

    public Form() {
        this.color = "white";
        counter++; // Incrementare la fiecare creare
    }

    public Form(String color) {
        this.color = color;
        counter++; // Incrementare la fiecare creare
    }

    // 7.6.1: Funcție getter statică pentru contor
    public static int getInstanceCount() {
        return counter;
    }

    public float getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "This form has the color " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Form) {
            Form f = (Form) obj;
            if (this.color == null && f.color == null) {
                return true;
            } else if (this.color != null && f.color != null && this.color.compareTo(f.color) == 0) {
                return true;
            }
        }
        return false;
    }
}