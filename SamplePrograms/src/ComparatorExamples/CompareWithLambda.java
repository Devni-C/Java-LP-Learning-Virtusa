package ComparatorExamples;

import java.util.ArrayList;
import java.util.List;

public class CompareWithLambda {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Devni", 54));
        employees.add(new Employee("Manuri", 44));
        employees.add(new Employee("Sonali", 50));
        employees.add(new Employee("Kasun", 66));

        System.out.println(employees);

        /*Comparator<Employee> employeeComparator = (e1, e2) -> {
            return (e1.getPoints() > e2.getPoints() ? +1 :
                    (e2.getPoints() > e1.getName()) ? -1 : 0);
        };*/

//        Collections.sort(employees, employeeComparator);
        System.out.println(employees);

        Vehicle vehicle = () -> System.out.println("Driving");
        vehicle.drive();
    }
}
