package chapter8;

import com.google.common.collect.Lists;

import java.util.List;

public class Task14 {
    public static void main(String[] args) {
        List<Double> doubles = Lists.newArrayList(1.0, 2.0 ,3.0 ,4.0 ,5.0);

        double sum = doubles.stream().reduce(0.0, (aDouble, aDouble2) -> aDouble + aDouble2);

        System.out.println(sum / doubles.size());

    }
}
