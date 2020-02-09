package com.devni.tlp.employeeservice.controller;

import com.devni.tlp.employeeservice.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @RequestMapping("/hello")
    public String greeting() {
        return "<h1>Hello from SpringBoot :D<h1>";
    }

    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getAllEmployees() {
        return Employee.getAllEmployees();
    }

    @RequestMapping(value = "/getbypath", method = RequestMethod.GET)
    @ResponseBody
    public String getByPath() { //method name can stat with any way
        return "This gets by Path";
    }
    /*
     * curl -i http://localhost:8080/services/getbypath
     * */

    @RequestMapping(value = "/usingpostmethod", method = POST)
    @ResponseBody
    public String postMethod() { //method name can start with any way
        return "This uses POST";
    }
    /*
     * curl -i -X POST http://localhost:8080/services/usingpostmethod
     *
     * */

    @RequestMapping(value = "/headersattribute", headers = "key=val", method = GET)
    @ResponseBody
    public String getWithHeders() { //method name can start with any way
        return "Get values with Header attribute";
    }
    /*
     * curl -i -H "key:val" http://localhost:8080/services/headersattribute
     * */

    @RequestMapping(value = "/multipleheaders",
            headers = {"key1=val1", "key2=val2"}, method = GET)
    @ResponseBody
    public String getMultipleHeaders() {
        return "Get with multiple headers";
    }
    /*
    * curl -i -H "key1:val1" -H "key2:val2" http://localhost:8080/services/multipleheaders
    * */

    @RequestMapping(
            value = "/mediatype",
            method = GET,
            headers = "Accept=Application/json")
    @ResponseBody
    public String getFooAsJsonFromBrowser() {
        return "Get foos with Header Old";
    }
    /*
    * curl -H "Accept:application/json,text/html"
      http://localhost:8080/services/mediatype
    * */

    @RequestMapping(
            value = "/produces",
            method = GET,
            produces = {"application/json", "application/xml"})
    public String getDemoProducesMultipleValues() {
        return "Supports multiple values";
    }
    /*
    * curl -H "Accept:application/json,text/html"
      http://localhost:8080/services/produces
    * */

    @RequestMapping(value = "/usingpathvariable/{id}", method = GET)
    @ResponseBody
//    public String getBySimplePathVariable(@PathVariable("id") int id) { //both method signatures are correct.
    public String getBySimplePathVariable(@PathVariable int id) { //Here, we can omit ("id") because, method parameter matches the name of the path variable
        return "Get values with path variable id = " + id;
    }
    /*
    * curl http://localhost:8080/usingpathvariable/1232
    * */

    @RequestMapping(
            value = "/usingmultiplepathvariables/one/{var_one}/two/{var_two}", method = GET)
    @ResponseBody
    public String getValueBySimplePathVariables(@PathVariable int var_one, @PathVariable int var_two) {
        return "Get variable one = " + var_one + " & variable two = " + var_two;
    }
   /*
   * curl http://localhost:8080/services/usingpathvariables/one/147/two/369
   * */

    @RequestMapping(value = "/withregex/{id:[\\d]}", method = GET)
    @ResponseBody
    public String getWIthRegex(@PathVariable int id) {
        return "Specific value = " + id;
    }
    /*
    * http://localhost:8080/services/withregex/1 //1 - this will work //123 - this won't work
    * */

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") int id) {
        if (id == 1) {
            System.out.println(id);
            Employee employee = new Employee();
            employee.setMarks(25);
            return employee;
        } else {
            return new Employee();
        }
    }
}
