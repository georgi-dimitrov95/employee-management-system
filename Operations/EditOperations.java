// provides static methods to execute editing operations
// uses EmployeeEditor to edit employee's properties
// used in the main application

package ExamOOP.Operations;

import ExamOOP.EmployeeUtil.*;
import ExamOOP.Menu.*;
import ExamOOP.EmployeeClasses.*;
import java.util.Scanner;

public class EditOperations {

//    combines all the editing operations in a single switch statement
    public static void operations(Worker worker, Scanner scanner, MenuOptions options) {
        System.out.println();
        String response;
        switch (worker.getType().toLowerCase()) {
            case "full time employee":
                editFullTimeEmployee(worker, scanner, options);
                break;
            case "intern":
                editIntern(worker, scanner, options);
                break;
            case "contractor":
                editContractor(worker, scanner, options);
                break;
        }
    }

//    each of the three methods below displays a menu, validates input and edits the Worker instance
    private static void editFullTimeEmployee(Worker worker, Scanner scanner, MenuOptions options) {
        while (true) {
            Menu.editFullTimeEmployeeMenu();
            System.out.print("Option: ");
            String response = scanner.nextLine().trim();

            if (!options.getEditFullTimeEmployeeOptions().contains(response)) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            if (response.equals("6")) {
                break;
            }
            EmployeeEditor.editFullTimeEmployee(worker, scanner, response);
        }
    }

    private static void editIntern(Worker worker, Scanner scanner, MenuOptions options) {
        while (true) {
            Menu.editInternMenu();
            System.out.print("Option: ");
            String response = scanner.nextLine().trim();

            if (!options.getEditInternOptions().contains(response)) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            if (response.equals("7")) {
                break;
            }
            EmployeeEditor.editIntern(worker, scanner, response);
        }
    }

    private static void editContractor(Worker worker, Scanner scanner, MenuOptions options) {
        while (true) {
            Menu.editContractorMenu();
            System.out.print("Option: ");
            String response = scanner.nextLine().trim();

            if (!options.getEditContractorOptions().contains(response)) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            if (response.equals("7")) {
                break;
            }
            EmployeeEditor.editContractor(worker, scanner, response);
        }
    }
}
