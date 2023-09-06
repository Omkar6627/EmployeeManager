package com.EmployeeManager.HR.Stats.Service;

import com.EmployeeManager.HR.Stats.Model.Attendance;
import com.EmployeeManager.HR.Stats.Model.Employee;
import com.EmployeeManager.HR.Stats.Repository.IAttendance;
import com.EmployeeManager.HR.Stats.Repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final IEmployee employeeRepository;
    @Autowired
    IAttendance attendanceRepository ;
    @Autowired
    public EmployeeService(IEmployee employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }



    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId);
    }
    public double calculateSalary(Long employeeId, LocalDate startDate, LocalDate endDate) {


        List<Attendance> attendanceRecords = attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);


        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {

            int totalDaysPresent = attendanceRecords.size();


            double dailySalary = employee.getSalary();


            return totalDaysPresent * dailySalary;
        }
    return -1;}
}

