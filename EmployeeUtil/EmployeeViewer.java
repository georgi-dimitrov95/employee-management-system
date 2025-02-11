//provides static methods for listing employees and their employment details
//used in the ListOperations class

package ExamOOP.EmployeeUtil;

import ExamOOP.EmployeeClasses.*;

public class EmployeeViewer {

//    lists all active employees
    public static void listAllEmployees(EmployeeManager employeeManager) {
        if (employeeManager.getActiveEmployees().isEmpty()) {
            System.out.println();
            System.out.println("No active employees found in the system.");
        } else {
            for (Worker worker : employeeManager.getActiveEmployees()) {
                worker.printEmploymentDetails();
                System.out.println("-".repeat(15));
            }
        }
    }

//    a single method that lists employees based on the specified type (full time, intern, contractor)
    public static void listEmployeesByType(EmployeeManager employeeManager, String type) {
        boolean anyFound = false;
        for (Worker worker : employeeManager.getActiveEmployees()) {
            if (worker.getType().equalsIgnoreCase(type)) {
                anyFound = true;
                worker.printEmploymentDetails();
                System.out.println("-".repeat(15));
            }
        }
        if (!anyFound) {
            System.out.println();
            System.out.println("No " + type + "s" +  " found in the system.");
        }
    }

//    lists all past employees
    public static void listPastEmployees(EmployeeManager employeeManager) {
        if (employeeManager.getPastEmployees().isEmpty()) {
            System.out.println();
            System.out.println("No archived employees found in the system.");
        } else {
            for (Worker worker : employeeManager.getPastEmployees()) {
                worker.printEmploymentDetails();
                System.out.println("-".repeat(15));
            }
        }
    }
}
