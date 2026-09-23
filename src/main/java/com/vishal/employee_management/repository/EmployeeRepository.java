package com.vishal.employee_management.repository;

import com.vishal.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    List<Employee> findAllByOrderBySalaryAsc();

    List<Employee> findAllByOrderBySalaryDesc();
}
