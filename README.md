# Employee Management System (CLI)

##  Overview
The **Employee Management System** is a Command-Line Interface (CLI) application written in **Java** that allows companies to efficiently manage their employees. The system provides functionalities for adding, updating, deleting, and retrieving employee information.

## Technologies Used
- **Java** (Core Java, OOP principles)
- **File Handling** (CSV)

## Features
- Add new employees with details such as name, position, department, salary and other.
- Update employee records.
- Remove employees from the system.
- Retrieve employee details based on user input.
- List and filter employees.
- Save and load employee data to/from a CSV file.

## Employee Entities

### Employed Interface
The `Employed` interface defines the core structure for all employees. It ensures that every employee has a salary, a role, and a method to print employment details.

### Worker Class
The `Worker` class is the base entity for all employees. It includes attributes such as `id`, `name`, `department`, `role`, `salary`, `startDate`, and `endDate`. This class implements the `Employed` interface and serves as a foundation for different types of employees.

### Full-Time Employee
A `FullTimeEmployee` is an employee who is permanently employed by the company. In addition to the basic worker attributes, this class includes an `annualBonus`, reflecting extra compensation given to full-time employees.

### Contractor
The `Contractor` class represents a temporary worker hired for a specific period or project. It extends the `Worker` class and adds fields such as `employerName` (the external company that employs the contractor) and `projectName` (the project they are assigned to).

### Intern
The `Intern` class represents a temporary trainee working at the company, usually for gaining work experience. This class extends `Worker` and includes additional attributes: `universityName` (the name of the university they are enrolled in) and `major` (their field of study).
