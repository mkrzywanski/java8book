package chapter4.task6;

//TODO
public class Main {
    public static void main(String[] args) {
        Item x = new DiscountedItem("asd", 2.0, 5);
        Item y = x;
        Item z = new Item("asd", 2.0);

        System.out.println(x.equals(y));
        System.out.println(y.equals(z));
        System.out.println(x.equals(z));
    }
}
