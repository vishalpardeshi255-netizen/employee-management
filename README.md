# Employee Management System

## Project Description
A Spring Boot based Employee Management System REST API.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger UI

## Features
- Create Employee
- Get All Employees
- Get Employee by ID
- Update Employee
- Delete Employee
- Search Employee by Name
- Search Employee by Department
- Sort Employees by Salary
- Salary Range Search
- Pagination
- Global Exception Handling
- Validation

 ## API Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET | `/employees` | Get all employees |
| POST | `/employees` | Create a new employee |
| GET | `/employees/{id}` | Get employee by ID |
| PUT | `/employees/{id}` | Update employee |
| DELETE | `/employees/{id}` | Delete employee |
| GET | `/employees/name/{name}` | Search employee by name |
| GET | `/employees/department/{department}` | Search employees by department |
| GET | `/employees/salary` | Search employees by salary range |
| GET | `/employees/sort/salary` | Sort employees by salary |
| GET | `/employees/page` | Get employees with pagination |

## API Documentation
Swagger UI is used for testing and documenting REST APIs.

## Author
Vishal Pardeshi
