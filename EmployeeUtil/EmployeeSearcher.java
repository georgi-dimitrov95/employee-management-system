// provides static methods for searching employees based on user input
// each method prints all employees that have a property matching the input
// used in the SearchOperations class

package ExamOOP.EmployeeUtil;

import ExamOOP.EmployeeClasses.*;
import java.util.Objects;

public class EmployeeSearcher {

//    also used in the "fire employee" option
    public static Worker searchID(EmployeeManager employeeManager, String idSearched) {
        try {
            int id = Integer.parseInt(idSearched);
            for (Worker worker : employeeManager.getActiveEmployees()) {
                if (worker.getId() == id) {
                    return worker;
                }
            }
            System.out.println();
            System.out.println("No employees found with ID: " + idSearched);
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    public static void searchType(EmployeeManager employeeManager, String type) {
        boolean found = false;
        for (Worker worker : employeeManager.getActiveEmployees()) {
            if (Objects.equals(worker.getType(), type)) {
                found = true;
                worker.printEmploymentDetails();
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("No employees found with type: " + type);
        }
    }

    public static void searchFullName(EmployeeManager employeeManager, String name) {
        boolean found = false;
        for (Worker worker : employeeManager.getActiveEmployees()) {
            if (Objects.equals(worker.getName(), name)) {
                found = true;
                worker.printEmploymentDetails();
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("No employees found with full name: " + name);
        }
    }

    public static void searchDepartment(EmployeeManager employeeManager, String department) {
        boolean found = false;
        for (Worker worker : employeeManager.getActiveEmployees()) {
            if (Objects.equals(worker.getDepartment(), department)) {
                found = true;
                worker.printEmploymentDetails();
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("No employees found in department: " + department);
        }
    }

    public static void searchRole(EmployeeManager employeeManager, String role) {
        boolean found = false;
        for (Worker worker : employeeManager.getActiveEmployees()) {
            if (Objects.equals(worker.getRole(), role)) {
                found = true;
                worker.printEmploymentDetails();
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("No employees found with role: " + role);
        }
    }
}
