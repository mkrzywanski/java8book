package chapter9;

import java.io.*;

public class Task13 {

    private static final String FILE_PATH = "src/main/resources/object_serialize";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee = new Employee(1,2);
        Employee employee1 = (Employee) clone(employee);

        System.out.println(employee.toString() + " " + employee1.toString());
        System.out.println("A " + employee.getA() + " " + employee1.getA());
        System.out.println("B " + employee.getB() + " " + employee1.getB());

    }

    private static Object clone(Object object) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Object deserialized = objectInputStream.readObject();
        objectInputStream.close();

        return deserialized;
    }

    private static class Employee implements Serializable {
        private int a;
        private int b;

        Employee(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int getA() {
            return a;
        }

        void setA(int a) {
            this.a = a;
        }

        int getB() {
            return b;
        }

        void setB(int b) {
            this.b = b;
        }
    }
}
