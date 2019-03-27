package chapter10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.Supplier;

import java.net.PasswordAuthentication;

public class Task25 {

    public static void main(String[] args) {

        Predicate<PasswordAuthentication> predicate = passwordAuthentication ->
            Arrays.equals(passwordAuthentication.getPassword(), "secret".toCharArray());

        Supplier<PasswordAuthentication> supplier = () -> {
            Scanner scanner = new Scanner(System.in);

            System.out.print("username : ");
            String userName = scanner.nextLine();

            System.out.print("password : ");
            String password = scanner.nextLine();

            return new PasswordAuthentication(userName, password.toCharArray());
        };

        repeat(supplier, predicate);
    }

    private static <T> CompletableFuture<T> repeat(Supplier<T> task, Predicate<T> condition) {
        try {
            if(!CompletableFuture.supplyAsync(task).thenApplyAsync(condition::test).get()) {
                System.out.println("Password incorrect !");
                return repeat(task, condition);
            } else {
                System.out.println("Correct !");
                return new CompletableFuture<>();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new CompletionException(e);
        }
    }
}
