import com.devni.training.salesmanager.model.Employee;
import com.devni.training.salesmanager.service.EmployeeService;
import com.devni.training.salesmanager.service.EmployeeServiceImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();

        List<Employee> employees = employeeService.getAllEmplyees();

        for(Employee employee : employees) {
            System.out.println(employee.getEmployeeName() + " at " +
                    employee.getEmployeeLocation());
        }
    }
}
