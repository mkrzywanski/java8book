package chapter14;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Arrays;

public class Task3 {

    private static final String SCRIPT_PATH = "src/main/resources/bubbleSort.js";
    private static final String ENGINE_NAME = "nashorn";

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        int[] arr = new int[]{6, 3, 3, 6, 7, 3, 5, 3, 5, 3, 5, 6, 3, 5, 7, 4, 5, 6, 7};

        benchmarkJava(arr.clone());

        benchmarkJavaScript(arr.clone());

    }

    private static void bubbleSort(int[] array) {
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    swap(array, i, i + 1);
                    hasChanged = true;
                }
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void benchmarkJava(int[] array) {
        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        long time = System.currentTimeMillis() - startTime;

        System.out.println("Java Time : " + time);
        System.out.println(Arrays.toString(array));
    }

    private static void benchmarkJavaScript(int[] array) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName(ENGINE_NAME);
        Invocable invocable = (Invocable) nashorn;

        nashorn.eval(new FileReader(SCRIPT_PATH));

        long startTime = System.currentTimeMillis();
        invocable.invokeFunction("bubbleSort", array);
        long time = System.currentTimeMillis() - startTime;

        System.out.println("JavaScript Time : " + time);
        System.out.println(Arrays.toString(array));
    }
}
