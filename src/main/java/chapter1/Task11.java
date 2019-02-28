package chapter1;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.next();
        char[] chars = sentence.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if(currentChar > 128) {
                System.out.println("Character " + currentChar + " unicode : " + Character.codePointAt(chars, i));
            }
        }
    }
}
