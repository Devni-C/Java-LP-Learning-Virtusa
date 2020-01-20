package Map;

import ComparatorExamples.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getAllEmployees().stream().map(e -> new Employee("Dr " + e.getName(),
                e.getPoints())).collect(Collectors.toList());

        System.out.println(employees);

        //List<Employee> employeesWithI = (List<Employee>) Employee.getAllEmployees().stream().filter(e -> e.getName().contains("i"));
                //new Employee("Dr " + e.getName(), e.getPoints())).Collect(Collectors.toList());

        //System.out.println(employeesWithI);

    }
}
