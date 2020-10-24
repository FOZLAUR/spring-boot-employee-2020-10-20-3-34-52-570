package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.models.Employee;
import com.thoughtworks.springbootemployee.models.EmployeeMapper;
import com.thoughtworks.springbootemployee.models.EmployeeResponse;
import com.thoughtworks.springbootemployee.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper){
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping()
    public List<EmployeeResponse> getAllEmployees(){
        List<Employee> employees = employeeService.getAll();
        return employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse getEmployee(@PathVariable int employeeId){
        return employeeMapper.toResponse(employeeService.findEmployee(employeeId));
    }

    @GetMapping(params = {"page","pageSize"})
    public List<EmployeeResponse> getPagedEmployees(int page, int pageSize){
        List<Employee> employees = employeeService.getEmployeeByPage(page, pageSize);
        return employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping(params = "gender")
    public List<EmployeeResponse> getEmployeesByGender(String gender){
        List<Employee> employees = employeeService.findEmployeesByGender(gender);
        return employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee newEmploy){
        return  employeeService.updateEmployee(employeeId, newEmploy);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
