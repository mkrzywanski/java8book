package chapter7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Task1 {

    private static final Integer marker = null;

    public static void main(String[] args) {
        List<Integer> primeNumbers = erastotenesThieve(200);

        primeNumbers.forEach(System.out::println);
    }

    private static List<Integer> erastotenesThieve(int n) {

        Boolean[] isPrimeArray = Stream.iterate(true, value -> true)
                .limit(n)
                .toArray(Boolean[]::new);

        for (int i = 2; i < Math.sqrt(n); i++) {
            if(isPrimeArray[i]) {
                for(int j = i * i; j < n; j += i) {
                    isPrimeArray[j] = false;
                }
            }
        }

        List<Integer> result = new LinkedList<>();

        for(int i = 2; i < isPrimeArray.length; i++) {
            if(isPrimeArray[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
