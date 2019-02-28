package chapter1;

public class MaximumNumberInArrayRecursive {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(max(arr, 0));
    }

    public static int max(int[] array, int index) {
        if(index == array.length - 1) {
            return array[index];
        } else {
            return Math.max(array[index], max(array, index+1));
        }
    }
}
