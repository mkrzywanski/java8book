package chapter5;

import java.util.Objects;

public class Task11 {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Required 2 arguments");
            return;
        }

        String arg1 = args[0];
        String arg2 = args[1];
        arg2 = null;

        int x = Integer.valueOf(arg1);

        assert x >= 0;

        Objects.requireNonNull(arg2, "Second argument cannot be null");
    }
}
