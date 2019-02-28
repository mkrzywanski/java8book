package chapter1;

public class Task9 {
    public static void main(String[] args) {
        String s = "test";
        String t = new String("test");
        System.out.println(s.equals(t));
        System.out.println(s == t);
    }
}
