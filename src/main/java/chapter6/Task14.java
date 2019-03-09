package chapter6;

import java.util.LinkedList;
import java.util.List;

public class Task14 {
    private static <T extends AutoCloseable> void closeAll(List<T> elements) throws Exception {
        List<Exception> exceptions = new LinkedList<>();

        for(T element : elements) {
            try {
                element.close();
            } catch (Exception e) {
                exceptions.add(e);
            }
        }

        if(exceptions.size() > 0) {
            throw createChainedException(exceptions);
        }
    }

    private static Exception createChainedException(List<Exception> exceptions) {
        Exception firstException = exceptions.get(0);
        Exception currentException = firstException;

        for(int j = 1; j < exceptions.size(); j++) {
            currentException.initCause(exceptions.get(j));
            currentException = exceptions.get(j);
        }

        return firstException;
    }
}
