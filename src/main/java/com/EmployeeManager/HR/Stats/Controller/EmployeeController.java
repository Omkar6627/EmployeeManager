package com.EmployeeManager.HR.Stats.Controller;

import com.EmployeeManager.HR.Stats.Model.Employee;
import com.EmployeeManager.HR.Stats.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/HR/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}/calculate-salary")
    public double calculateSalary(@PathVariable Long id, @PathVariable LocalDate dateFrom,@PathVariable LocalDate dateTo) {
        return employeeService.calculateSalary(id,dateFrom,dateTo);
    }
}