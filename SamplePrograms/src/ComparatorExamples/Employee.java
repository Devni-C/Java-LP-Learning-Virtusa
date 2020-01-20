package ComparatorExamples;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int points;

    public Employee(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Devni", 45));
        employeeList.add(new Employee("Manuri", 66));
        employeeList.add(new Employee("Thurani", 32));
        employeeList.add(new Employee("Sonali", 78));
        employeeList.add(new Employee("Kasun", 42));
        employeeList.add(new Employee("Rashan", 58));

        return employeeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints() {
        this.points = points;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPoints();
    }
}
