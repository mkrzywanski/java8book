package chapter5;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Task14 {

    private static Logger logger = Logger.getLogger(Task14.class.getName());

    public static void main(String[] args) {
        logger.setUseParentHandlers(false);
        
        ConsoleHandler consoleHandler = new ConsoleHandler();

        consoleHandler.setFormatter(new HtmlFormatter());

        logger.addHandler(consoleHandler);

        logger.info("Html format");
    }

    private static class HtmlFormatter extends Formatter {

        @Override
        public String format(LogRecord logRecord) {
            return "<b>" + logRecord.getMessage() + "</b>";
        }
    }
}
