package chapter8;

import javax.lang.model.SourceVersion;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task7 {
    public static void main(String[] args) {

    }

    private static Stream<String> getTokenByCondition(List<String> lines, long limit) {
        return lines.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .filter(SourceVersion::isIdentifier)
                .limit(limit);
    }
}
