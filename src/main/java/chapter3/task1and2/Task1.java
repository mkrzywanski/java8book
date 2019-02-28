package chapter3.task1and2;

import java.util.Arrays;
import java.util.Comparator;

public class Task1 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("name1", 1);
        Employee employee2 = new Employee("name2",2);
        Employee employee3 = new Employee("name3",3);
        Employee employee4 = new Employee("name4",4);

        Measurable[] employees = new Measurable[]{employee1, employee2, employee3, employee4};

        System.out.println(average(employees));

        Employee employeeWithMaxSalary = (Employee) max(employees);

        System.out.println(employeeWithMaxSalary.getName());
    }

    private static double average(Measurable[] objects) {
        return Arrays.stream(objects)
                .mapToDouble(Measurable::getMeasure)
                .average()
                .getAsDouble();
    }

    private static Measurable max(Measurable[] objects) {
        return Arrays.stream(objects)
                .max(Comparator.comparing(Measurable::getMeasure))
                .get();
    }
}
