// provides static methods that search by various properties based on user's input
// the methods displays employee(s) details if any are found
// uses EmployeeSearcher to facilitate the search + printing
// used in the main application

package ExamOOP.Operations;

import ExamOOP.EmployeeClasses.*;
import ExamOOP.EmployeeUtil.*;
import ExamOOP.Menu.*;
import ExamOOP.OtherUtil.Prompter;

import java.util.Scanner;

public class SearchOperations {
    public static void operations(EmployeeManager manager, Scanner scanner, MenuOptions options) {
        while (true) {
            Menu.searchMenu();
            System.out.print("Option: ");
            String response = scanner.nextLine().trim();

//            input validation
            if (!options.getSearchOptions().contains(response)) {
                System.out.println();
                System.out.println("Invalid option. Please try again.");
                continue;
            }
            if (response.equals("5")) {
                break;
            }

//            determines which search to conduct based on user input
            switch (response) {
                case "1":
                    searchByID(manager, scanner);
                    break;
                case "2":
                    searchByName(manager, scanner);
                    break;
                case "3":
                    searchByDepartment(manager, scanner);
                    break;
                case "4":
                    searchByRole(manager, scanner);
                    break;
            }
        }
    }

    public static void searchByID(EmployeeManager manager, Scanner scanner) {
        System.out.print("ID: ");
        String idSearched = scanner.nextLine().trim();
//        searchID method differs a bit from the other search methods in EmployeeSearcher because it implements more robust input validation
        Worker workerSearched = EmployeeSearcher.searchID(manager, idSearched);
        if (workerSearched != null) {
            workerSearched.printEmploymentDetails();
        }
    }

    public static void searchByName(EmployeeManager manager, Scanner scanner) {
        String nameSearched = Prompter.namePrompt(scanner);
        EmployeeSearcher.searchFullName(manager, nameSearched);
    }

    public static void searchByDepartment(EmployeeManager manager, Scanner scanner) {
        String deptSearched = Prompter.departmentPrompt(scanner);
        EmployeeSearcher.searchDepartment(manager, deptSearched);
    }

    public static void searchByRole(EmployeeManager manager, Scanner scanner) {
        String roleSearched = Prompter.rolePrompt(scanner);
        EmployeeSearcher.searchRole(manager, roleSearched);
    }
}
