package chapter1;

public class Task16 {
    public static void main(String[] args) {
        System.out.println(average(1.1, 1.2));
    }

    public static double average(double d, double... values) {
        double sum = d;
        for(double val : values) {
            sum += val;
        }
        return sum / (values.length + 1);
    }
}
