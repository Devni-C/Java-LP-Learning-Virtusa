import com.devni.training.salesmanager.model.Employee;
import com.devni.training.salesmanager.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //EmployeeService employeeService = new EmployeeServiceImpl();

        EmployeeService employeeService =
                applicationContext.getBean("employeeService", EmployeeService.class);

        List<Employee> employees = employeeService.getAllEmployees();

        for(Employee employee : employees) {
            System.out.println(employee.getEmployeeName() + " at " +
                    employee.getEmployeeLocation());
        }
    }
}
