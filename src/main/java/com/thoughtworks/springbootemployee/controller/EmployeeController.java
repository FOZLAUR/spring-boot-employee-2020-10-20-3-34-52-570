package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.models.Employee;
import com.thoughtworks.springbootemployee.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final List<Employee> employeeList = new ArrayList<>();
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

//    GET       /employees    #obtain employee list
    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

//    GET       /employees/1  # obtain a certain specific employee
    @GetMapping("/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeID() == employeeID)
                .findFirst()
                .orElse(null);
    }

//    GET       /employees?page=1&pageSize=5  #Page query, page equals 1, pageSize equals 5
    @GetMapping(params = {"page","pageSize"})
    public List<Employee> getPagedEmployees(int page, int pageSize){
        int pageSkip = (page-1) * pageSize;
        return employeeList.stream()
                .skip(pageSkip)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

//    GET       /employees?gender=male   #screen all male employees
    @GetMapping(params = "gender")
    public List<Employee> getAllMaleEmployees(String gender){
        return employeeList.stream()
                .filter(employee -> employee.getGender().equals(gender))
                .collect(Collectors.toList());
    }

//    POST      /employees    # add an employee
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

//    PUT       /employees/1  #update an employee
    @PutMapping("/{employeeID}")
    public void updateEmployee(@PathVariable int employeeID, @RequestBody Employee newEmploy){
        employeeList.stream()
                .filter(employee -> employee.getEmployeeID() == employeeID)
                .findFirst()
                .ifPresent(employee -> {
                        employeeList.remove(employee);
                        employeeList.add(newEmploy);
                });
    }

//    DELETE    /employees/1  #delete an employee
    @DeleteMapping("/{employeeID}")
    public void deleteEmployee(@PathVariable int employeeID){
        employeeList.stream()
                .filter(employee -> employee.getEmployeeID() == employeeID)
                .findFirst()
                .ifPresent(employee -> {
                    employeeList.remove(employee);
                });
    }
}