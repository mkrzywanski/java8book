package chapter3;

import java.io.File;
import java.util.Arrays;

public class Task11 {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Two parameters must be given");
            return;
        }

        String dirPath = args[0];
        String extension = args[1];

        File directoryFile = new File(dirPath);

        if(!directoryFile.isDirectory()) {
            System.out.println("Given file is not an directory");
            return;
        }

        String fullExtension = "." + extension;

        String[] fileNames = directoryFile.list((file, fileName) -> fileName.endsWith(fullExtension));

        if(fileNames != null) {
            Arrays.stream(fileNames).forEach(System.out::println);
        } else {
            System.out.println("No files with extension " + fullExtension + " in directory " + dirPath);
        }
    }
}
