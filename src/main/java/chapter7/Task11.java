package chapter7;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Task11 {

    public static void main(String[] args) {

        List<String> sentetce = Lists.newArrayList("1", "2", "3", "4", "5");

        List<String> subList = sentetce.subList(1, sentetce.size() - 1);

        Collections.shuffle(subList);

        sentetce.forEach(System.out::println);

    }
}
