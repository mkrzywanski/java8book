package chapter1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13 {
    private static final int WINNING_NUMBERS_AMOUNT = 6;
    private static final int LOTTO_NUMBERS_AMOUNT = 49;

    public static void main(String[] args) {
        List<Integer> lottoNumbers = Stream.iterate(1, t -> t + 1)
                .limit(LOTTO_NUMBERS_AMOUNT)
                .collect(Collectors.toList());

        List<Integer> winningNumbers = new ArrayList<>(WINNING_NUMBERS_AMOUNT);

        Random random = new Random();
        for(int i = 0; i < WINNING_NUMBERS_AMOUNT; i ++) {
            int index = random.nextInt(lottoNumbers.size());
            int number = lottoNumbers.get(index);

            winningNumbers.add(number);
            lottoNumbers.remove(index);
        }

        winningNumbers.sort(Comparator.naturalOrder());

        winningNumbers.forEach(System.out::println);

    }
}
