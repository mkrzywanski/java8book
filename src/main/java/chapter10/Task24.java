package chapter10;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Task24 {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(Task24::askForUrl)
                .thenApply(Task24::downloadPage)
                .thenApply(Task24::extractHyperlinks)
                .thenAccept(Task24::showHyperlinks);

        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);

    }

    private static URL askForUrl() {
        System.out.println("Give url :");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            return new URL(input);
        } catch (MalformedURLException e) {
            System.out.println("Malformed url");
            throw new CompletionException(e);
        }
    }

    private static String downloadPage(URL url) {
        try {
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                return bufferedReader.lines().collect(Collectors.joining());
            }

        } catch (IOException e) {
            throw new CompletionException(e);
        }
    }

    private static List<URL> extractHyperlinks(String pageContent) {
        System.out.println(pageContent);

        String[] split = pageContent.split("<a href=");

        return Arrays.stream(split)
                .map(line -> {
                    int index = line.indexOf(">");
                    return line.substring(0, index)
                            .replaceAll("\"", "");
                })
                .map(link -> {
                    try {
                        return Optional.of(new URL(link));
                    } catch (MalformedURLException e) {
                        return Optional.<URL>empty();
                    }
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private static void showHyperlinks(List<URL> urls) {
        urls.forEach(url -> System.out.println(url.toString()));
    }
}
