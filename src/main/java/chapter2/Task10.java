package chapter2;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

public class Task10 {

    private static Random generator = new Random();

    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1,2,3,4,5);
        System.out.println("Random element " + randomElement(numbers));
    }

    private static int nextInt(int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }

    private static int randomElement(List<Integer> numbers) {
        if(numbers.isEmpty()) {
            return 0;
        } else {
            int index = nextInt(0, numbers.size() - 1);
            return numbers.get(index);
        }
    }
}
