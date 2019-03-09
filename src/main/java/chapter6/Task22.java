package chapter6;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Task22 {

    public static void main(String[] args) {

        Callable<Integer> callable = () -> {
            int i = 0;

            if(i == 0) {
                throw new IllegalArgumentException();
            }

            return 1;
        };

        doWork(callable, IllegalArgumentException::new);
    }

    private static <V, T extends Exception> V doWork(Callable<V> callable, Supplier<T> constr) throws T {

        try {
            return callable.call();
        } catch (Throwable realEx) {
            Exception exception = constr.get();
            exception.initCause(realEx);
            throw (T) exception;
        }

    }

}
