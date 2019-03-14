package chapter8;

import javax.lang.model.SourceVersion;

public class Task6 {

    public static void main(String[] args) {
        String alphabeticWord = "Test";

        System.out.println(alphabeticWord + " is alphabetic : " + isAlphabetic(alphabeticWord));

        String notAlphabeticWord = "Test1";

        System.out.println(notAlphabeticWord + " is alphabetic " + isAlphabetic(notAlphabeticWord));
    }

    private static boolean isAlphabetic(String word) {
        return word.codePoints()
                .allMatch(Character::isAlphabetic);
    }

    private static boolean isJavaIdentifier(String word) {
        return SourceVersion.isIdentifier(word);
    }
}
