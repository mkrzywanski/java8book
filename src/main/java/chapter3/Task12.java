package chapter3;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Task12 {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please supply directory path");
            return;
        }

        String dirPath = args[0];

        File directoryFile = new File(dirPath);

        if(!directoryFile.isDirectory()) {
            System.out.println("Given file is not an directory");
            return;
        }

        File[] files = directoryFile.listFiles();

        if(files == null) {
            System.out.println("Directory is empty");
            return;
        }

        System.out.println("Files before sorting\n");
        Arrays.stream(files).forEach(System.out::println);

        Comparator<File> comparator = Comparator
                .comparing(File::isDirectory).reversed()
                .thenComparing(File::getName);

        Arrays.sort(files, comparator);

        System.out.println("\nFiles after sorting\n");
        Arrays.stream(files).forEach(System.out::println);

    }
}
