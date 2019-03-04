package chapter5;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Task13 {
    private static Logger logger = Logger.getLogger(Task13.class.getName());

    public static void main(String[] args) {
        logger.setFilter(new BadWordsFilter());
        logger.info("sex is good");
        logger.info("Message that will be logged");
    }

    private static class BadWordsFilter implements Filter {
        private static Set<String> badWords = new HashSet<>();

        static {
            badWords.add("C++");
            badWords.add("drugs");
            badWords.add("sex");
        }

        @Override
        public boolean isLoggable(LogRecord logRecord) {
            return badWords.stream()
                    .noneMatch(badWord -> logRecord.getMessage().contains(badWord));
        }
    }

}
