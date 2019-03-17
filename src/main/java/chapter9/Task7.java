package chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task7 {

    private static final String FILE_PATH = "src/main/resources/war_and_peace";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        byte[] fileBytes = Files.readAllBytes(Paths.get(FILE_PATH));

        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

        for (byte val : fileBytes) {
            messageDigest.update(val);

            byte[] digest = messageDigest.digest();

            System.out.println(byteArrayToHexString(digest));
        }

    }

    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();

        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return result.toString();
    }
}
