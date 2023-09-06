package com.EmployeeManager.HR.Stats.Service;

import com.EmployeeManager.HR.Stats.Model.Attendance;
import com.EmployeeManager.HR.Stats.Model.Employee;
import com.EmployeeManager.HR.Stats.Repository.IAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    private final IAttendance attendanceRepository;

    @Autowired
    public AttendanceService(IAttendance attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    public Attendance recordAttendance(Attendance attendance) {

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByEmployee(Optional<Employee> employee) {

        return attendanceRepository.findByEmployee(employee);
    }


}