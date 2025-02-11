package ExamOOP;

import ExamOOP.CsvUtil.*;
import ExamOOP.EmployeeClasses.*;
import ExamOOP.EmployeeUtil.*;
import ExamOOP.Menu.*;
import ExamOOP.Operations.*;
import ExamOOP.OtherUtil.Prompter;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) throws IOException {
//        paths to the files which will be read from/written to
        String activeEmployeesFilePath = "SirmaAcademyHomework/ExamOOP/csv/activeEmployees.csv";
        String pastEmployeesFilePath = "SirmaAcademyHomework/ExamOOP/csv/pastEmployees.csv";

        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        MenuOptions options = new MenuOptions();
//        loads data from CSV files
        CsvReader.readEmployeesFromCSV(activeEmployeesFilePath, manager.getActiveEmployees());
        CsvReader.readEmployeesFromCSV(pastEmployeesFilePath, manager.getPastEmployees());

        Menu.greetingMenu();
        Menu.inputExamples();

//        main loop of the program
        while (true) {
            Menu.mainMenu();
            System.out.print("Option: ");
            String mainMenuResponse = scanner.nextLine().trim();

//            initial input validation
            if (!options.getMainOptions().contains(mainMenuResponse)) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (mainMenuResponse) {
//                create and add an employee (full time, intern, contractor)
                case "1":
                    AddOperations.operations(manager, scanner, options);
                    break;
//                edit employee
                case "2":
                    System.out.print("\nEnter the ID of the employee you wish to edit: ");
                    String editID = scanner.nextLine().trim();
//                    if an employee is not found the Worker instance will be assigned "null"
                    Worker workerToEdit = EmployeeSearcher.searchID(manager, editID);
                    if (workerToEdit != null) {
                        System.out.println("\nThe employee has been found. Employment details:");
                        workerToEdit.printEmploymentDetails();
                        EditOperations.operations(workerToEdit, scanner, options);
                    }
                    break;
//                fire an employee
                case "3":
                    System.out.print("Enter the ID of the employee you wish to fire: ");
                    String idToFire = scanner.nextLine().trim();
//                    same as in the "edit" option above - the instance will be "null" if not found
                    Worker workerToFire = EmployeeSearcher.searchID(manager, idToFire);
                    if (workerToFire != null) {
                        System.out.println("\nThe employee has been found. Employment details:");
                        workerToFire.printEmploymentDetails();
                        System.out.println();
//                        runs the input through validation processes until a valid date is typed
                        String endDate = Prompter.endDatePrompt(scanner, workerToFire.getStartDate());
                        workerToFire.setEndDate(endDate);
                        manager.fireEmployee(workerToFire);
                        System.out.println("\nThe employee has been fired.");
                    }
                    break;
//                list employees
                case "4":
                    ListOperations.operations(manager, scanner, options);
                    break;
//                search employees and print matches
                case "5":
                    SearchOperations.operations(manager, scanner, options);
                    break;
//                saves data to the csv files and exits the program
                case "6":
                    CsvWriter.writeEmployeesToCSV(activeEmployeesFilePath, manager.getActiveEmployees());
                    CsvWriter.writeEmployeesToCSV(pastEmployeesFilePath, manager.getPastEmployees());
                    System.out.println("\nThank you for using the Employee Management Application. Have a nice remainder of the day!");
                    System.exit(0);
            }
        }
    }
}
