package chapter3;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 {
    public static void main(String[] args) {
        Employee employee = new Employee("Doe", 240.3);
        Employee employee1 = new Employee("Doe", 344324.3);
        Employee employee2 = new Employee("Who", 240.3);
        Employee employee3 = new Employee("Do", 37655.3);
        Employee employee4 = new Employee("While", 110.3);
        Employee employee5 = new Employee("While", 33240.3);

        Employee[] employees = new Employee[] {employee, employee1, employee2, employee3, employee4, employee5};

        printEmployees(employees);

        Comparator<Employee> employeeComparator = Comparator
                .comparing(Employee::getPayment)
                .thenComparing(Employee::getSurname);

        Arrays.sort(employees, employeeComparator);

        printEmployees(employees);

        Comparator<Employee> employeeComparatorReversed = employeeComparator.reversed();

        Arrays.sort(employees, employeeComparatorReversed);

        printEmployees(employees);
    }

    private static class Employee {

        private String surname;
        private Double payment;

        public Employee(String surname, Double payment) {
            this.surname = surname;
            this.payment = payment;
        }

        public String getSurname() {
            return surname;
        }

        public Double getPayment() {
            return payment;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "surname='" + surname + '\'' +
                    ", payment=" + payment +
                    '}';
        }
    }

    private static void printEmployees(Employee[] employees) {
        Arrays.stream(employees).forEach(System.out::println);
        System.out.println();
    }
}
