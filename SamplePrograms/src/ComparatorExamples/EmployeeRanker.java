package ComparatorExamples;

import java.util.Comparator;

public abstract class EmployeeRanker implements Comparator<Employee> {

    @Override
    public int compare (Employee e1, Employee e2) {
        if(e1.getPoints() > e2.getPoints())
            return +1;
        if(e1.getPoints() < e2.getPoints())
            return  -1;
        return  0;
    }
}
