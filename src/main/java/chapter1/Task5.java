package chapter1;

public class Task5 {
    public static void main(String[] args) {
        double maxDouble = Double.MAX_VALUE;
        System.out.println("Double = " + maxDouble);
        System.out.println("Double binary = " + Long.toBinaryString(Double.doubleToLongBits(maxDouble)));
        Integer casted = (int) maxDouble;
        System.out.println("Double casted to int = " + casted);
        System.out.println("Double casted to int binary = " + Integer.toBinaryString(casted));
    }
}
