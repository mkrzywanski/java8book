package chapter5;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Task8 {
    public static void main(String[] args) throws IOException {
        try (MyAutoCloseable autoCloseable = createReentrantLock()) {

        }
    }

    private static MyAutoCloseable createReentrantLock() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        return reentrantLock::unlock;
    }

    private interface MyAutoCloseable extends AutoCloseable {
        void close();
    }

 }
