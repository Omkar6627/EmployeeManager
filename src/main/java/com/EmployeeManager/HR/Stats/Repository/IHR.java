package com.EmployeeManager.HR.Stats.Repository;

import com.EmployeeManager.HR.Stats.Model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHR extends JpaRepository<HR, Long> {

    HR findByUsername(String username);
}
