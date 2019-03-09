package chapter6.task3;

class Main {
    public static void main(String[] args) {
        Table<Integer, String> table = new Table<>();

        table.put(1, "1");
        table.put(2, "2");

        System.out.println("Table size = " + table.size());

        System.out.println("Key 1 value = " + table.get(1));

        System.out.println("Removing key 1");

        table.remove(1);

        System.out.println("Table size after remove = " + table.size());

        System.out.println("Key 1 value = " + table.get(1));
    }
}
