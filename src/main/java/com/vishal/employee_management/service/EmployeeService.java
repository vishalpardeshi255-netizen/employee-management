package com.vishal.employee_management.service;

import com.vishal.employee_management.entity.Employee;
import com.vishal.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );
    }
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> getEmployeesBySalaryAsc() {
        return employeeRepository.findAllByOrderBySalaryAsc();
    }

    public List<Employee> getEmployeesBySalaryDesc() {
        return employeeRepository.findAllByOrderBySalaryDesc();
    }

    public List<Employee> getEmployeesBySalaryRange(
            double minSalary,
            double maxSalary) {

        return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
    }

    public Page<Employee> getEmployeesWithPagination(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    // DELETE
    public void deleteEmployee(Long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        employeeRepository.delete(existingEmployee);
    }
}