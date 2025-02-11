// provides a static method which validates user input and prints employees based on the input's value
// uses EmployeeViewer to print the employees and their details
// used in the main application

package ExamOOP.Operations;

import ExamOOP.EmployeeUtil.*;
import ExamOOP.Menu.*;
import java.util.Scanner;

public class ListOperations {

    public static void operations(EmployeeManager manager, Scanner scanner, MenuOptions options) {
        while (true) {
            Menu.listMenu();
            System.out.print("Option: ");
            String listMenuResponse = scanner.nextLine().trim();
//            validation checks
            if (!options.getListOptions().contains(listMenuResponse)) {
                System.out.println();
                System.out.println("Invalid option. Please try again.");
                continue;
            }
            if (listMenuResponse.equals("6")) {
                break;
            }

            switch (listMenuResponse) {
                case "1":
//                    list all employees
                    EmployeeViewer.listAllEmployees(manager);
                    break;
                case "2":
//                    list full time employees
                    EmployeeViewer.listEmployeesByType(manager, "full time employee");
                    break;
                case "3":
//                    list interns
                    EmployeeViewer.listEmployeesByType(manager, "intern");
                    break;
                case "4":
//                    list contractors
                    EmployeeViewer.listEmployeesByType(manager, "contractor");
                    break;
                case "5":
//                    list past employees
                    EmployeeViewer.listPastEmployees(manager);
                    break;
            }
        }
    }
}
