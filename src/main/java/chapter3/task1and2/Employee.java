package chapter3.task1and2;

public class Employee implements Measurable {
    private int payment;
    private String name;

    public Employee(String name, int payment) {
        this.name = name;
        this.payment = payment;
    }

    @Override
    public double getMeasure() {
        return payment;
    }

    public String getName() {
        return name;
    }
}
