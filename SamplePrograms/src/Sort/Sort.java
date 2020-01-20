package Sort;

import ComparatorExamples.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getAllEmployees().stream().
                sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

        System.out.println(employees);

        List<Employee> employeeList = Employee.getAllEmployees().stream().
                sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());

        System.out.println(employeeList);

        List<Employee> emp = Employee.getAllEmployees().stream().
                sorted((e1, e2) -> new Integer(e1.getName().length()).
                        compareTo(e2.getName().length())).collect(Collectors.toList());

        System.out.println(emp);
    }
}
