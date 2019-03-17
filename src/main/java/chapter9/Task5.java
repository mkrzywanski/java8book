package chapter9;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5 {

    private static Map<String, List<String>> charsetToReplacements = new HashMap<>();

    public static void main(String[] args) {

        Charset.availableCharsets().forEach((name, charset) -> {
            try {
                byte[] replacementBytes = charset.newEncoder()
                        .replacement();

                String replacement = charset.decode(ByteBuffer.wrap(replacementBytes))
                        .toString();

                if(charsetToReplacements.containsKey(replacement)) {
                    charsetToReplacements.get(replacement).add(name);
                } else {
                    List<String> charsetNames = new LinkedList<>();
                    charsetNames.add(name);
                    charsetToReplacements.put(replacement, charsetNames);
                }

            } catch (UnsupportedOperationException e) {
                System.out.println("Charset " + name + " does not support encoding");
            }
        });

        System.out.println();

        charsetToReplacements.forEach((replacement, charsetNames) ->
            System.out.println("Replacement character " + replacement + " for charsets " +
                    charsetNames.stream().collect(Collectors.joining(" ")))
        );

    }
}
