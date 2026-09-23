package com.vishal.employee_management.controller;

import com.vishal.employee_management.entity.Employee;
import com.vishal.employee_management.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(
        name = "Employee Management",
        description = "REST APIs for managing employees"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // =========================
    // GET ALL EMPLOYEES
    // =========================

    @Operation(
            summary = "Get all employees",
            description = "Returns a list of all employees"
    )
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    // =========================
    // CREATE EMPLOYEE
    // =========================

    @Operation(
            summary = "Create employee",
            description = "Creates a new employee"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(
            @Valid @RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }


    // =========================
    // GET EMPLOYEE BY ID
    // =========================

    @Operation(
            summary = "Get employee by ID",
            description = "Returns an employee using the employee ID"
    )
    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }


    // =========================
    // UPDATE EMPLOYEE
    // =========================

    @Operation(
            summary = "Update employee",
            description = "Updates an existing employee using the employee ID"
    )
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }


    // =========================
    // DELETE EMPLOYEE
    // =========================

    @Operation(
            summary = "Delete employee",
            description = "Deletes an employee using the employee ID"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);
    }


    // =========================
    // SEARCH BY DEPARTMENT
    // =========================

    @Operation(
            summary = "Search employees by department",
            description = "Returns employees belonging to a specific department"
    )
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(
            @PathVariable String department) {

        return employeeService.getEmployeesByDepartment(department);
    }


    // =========================
    // SEARCH BY NAME
    // =========================

    @Operation(
            summary = "Search employees by name",
            description = "Searches employees using a name keyword"
    )
    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByName(
            @PathVariable String name) {

        return employeeService.getEmployeesByName(name);
    }


    // =========================
    // SEARCH BY SALARY RANGE
    // =========================

    @Operation(
            summary = "Search employees by salary range",
            description = "Returns employees whose salary is between minimum and maximum values"
    )
    @GetMapping("/salary")
    public List<Employee> getEmployeesBySalaryRange(
            @RequestParam double min,
            @RequestParam double max) {

        return employeeService.getEmployeesBySalaryRange(min, max);
    }


    // =========================
    // SORT SALARY ASCENDING
    // =========================

    @Operation(
            summary = "Sort employees by salary ascending",
            description = "Returns employees ordered from lowest salary to highest salary"
    )
    @GetMapping("/sort/salary")
    public List<Employee> getEmployeesBySalaryAsc() {

        return employeeService.getEmployeesBySalaryAsc();
    }


    // =========================
    // SORT SALARY DESCENDING
    // =========================

    @Operation(
            summary = "Sort employees by salary descending",
            description = "Returns employees ordered from highest salary to lowest salary"
    )
    @GetMapping("/sort/salary/desc")
    public List<Employee> getEmployeesBySalaryDesc() {

        return employeeService.getEmployeesBySalaryDesc();
    }


    // =========================
    // PAGINATION
    // =========================

    @Operation(
            summary = "Get employees with pagination",
            description = "Returns employees using pagination and sorting"
    )
    @GetMapping("/page")
    public Page<Employee> getEmployeesWithPagination(
            Pageable pageable) {

        return employeeService.getEmployeesWithPagination(pageable);
    }
}