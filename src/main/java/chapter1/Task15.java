package chapter1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        System.out.print("Height of triangle = ");
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();

        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> triangleTop = new LinkedList<>();
        triangleTop.add(1);
        triangle.add(triangleTop);

        for (int i = 1; i < height; i++) {
            List<Integer> upperLayer = triangle.get(i - 1);
            List<Integer> newLayer = new LinkedList<>();

            int numbersInLayer = i + 1;

            for (int j = 0; j < numbersInLayer; j++) {
                int currentLayerElement = 0;
                if (j - 1 >= 0) {
                    currentLayerElement += upperLayer.get(j - 1);
                }
                if (j < upperLayer.size()) {
                    currentLayerElement += upperLayer.get(j);
                }
                newLayer.add(currentLayerElement);
            }
            triangle.add(newLayer);
        }

        for(List<Integer> layer : triangle) {
            for(int number : layer) {
                System.out.print(number);
            }
            System.out.println();
        }
    }
}
