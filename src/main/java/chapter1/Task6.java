package chapter1;

import java.math.BigInteger;

public class Task6 {
    public static void main(String[] args) {
        BigInteger factorial = factorial(1000);
        System.out.println(factorial.toString());
    }

    private static BigInteger factorial(int n) {
        if(n == 0 || n == 1) {
            return new BigInteger("1");
        }

        BigInteger output = new BigInteger("1");

        for(int i = 1; i < n; i++) {
            output = output.multiply(new BigInteger("" + i));
        }

        return output;
    }
}
