package chapter9;

import com.google.common.collect.Sets;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static java.nio.charset.StandardCharsets.*;

public class Task3 {

    private static final String FILE_PATH = "src/main/resources/war_and_peace";

    private static final Set<Charset> CHARSETS = Sets.newHashSet();

    static {
        CHARSETS.add(US_ASCII);
        CHARSETS.add(ISO_8859_1);
        CHARSETS.add(UTF_8);
        CHARSETS.add(UTF_16BE);
        CHARSETS.add(UTF_16LE);
    }

    public static void main(String[] args) throws IOException {

        byte[] fileBytes = Files.readAllBytes(Paths.get(FILE_PATH));

        Charset detectedCharset = null;

        for(Charset charset : CHARSETS) {
            try {

                charset.newDecoder().decode(ByteBuffer.wrap(fileBytes));
                detectedCharset = charset;
                break;

            } catch (CharacterCodingException e) {
                e.printStackTrace();
            }
        }

        if (detectedCharset == null) {
            System.out.println("No charset could be detected");
        } else {
            System.out.println("Detected charset : " + detectedCharset.displayName());
        }
    }
}
