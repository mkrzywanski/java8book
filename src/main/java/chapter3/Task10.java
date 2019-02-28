package chapter3;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please supply directory path");
        }

        String dirPath = args[0];

        File directoryFile = new File(dirPath);

        if(!directoryFile.isDirectory()) {
            System.out.println("Given file is not an directory");
        }

        //File[] directoriesInGivenDirectory = file.listFiles(File::isDirectory);
        //File[] directoriesInGivenDirectory = file.listFiles(file1 -> file1.isDirectory());
        File[] subdirectoriesInGivenDirectory = directoryFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });

        if(subdirectoriesInGivenDirectory != null) {
            Arrays.stream(subdirectoriesInGivenDirectory)
                    .forEach(directory -> System.out.println(directory.getName()));
        } else {
            System.out.println("No subdirectories in given directory");
        }

    }

}
