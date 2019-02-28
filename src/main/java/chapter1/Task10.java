package chapter1;

import java.util.Random;

public class Task10 {
    private static final int FIRST_INTERVAL_LENGTH = 10;


    public static void main(String[] args) {
        System.out.println(randomString(20));
    }

    private static String randomString(int signAmount) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        long randomLong = Math.abs(random.nextLong());

        do {
            long moduloRest = randomLong % 36;
            randomLong = randomLong / 36;

            char base36Char = intToChar36Base(moduloRest);

            stringBuilder.insert(0, base36Char);
        } while (randomLong != 0);

        return stringBuilder.toString();
    }

    private static char intToChar36Base(long characterAsciiOffset) {
        if(characterAsciiOffset < FIRST_INTERVAL_LENGTH) {
            return (char)('0' + characterAsciiOffset);
        } else {
            return (char)('A' + characterAsciiOffset - FIRST_INTERVAL_LENGTH);
        }

    }
}
