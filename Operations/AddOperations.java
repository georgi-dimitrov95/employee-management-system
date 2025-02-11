// provides static methods for creating the superclass Worker and its subclasses FullTimeEmployee, Intern, Contractor
// used in the main application

package ExamOOP.Operations;

import ExamOOP.EmployeeClasses.*;
import ExamOOP.EmployeeUtil.*;
import ExamOOP.Menu.*;
import ExamOOP.OtherUtil.Prompter;

import java.util.Scanner;

public class AddOperations {
//    combines all the creation & adding operations into a single method
    public static void operations(EmployeeManager manager, Scanner scanner, MenuOptions options) {
        while (true) {
            Menu.addEmployeeMenu();
            System.out.print("Option: ");
            String response = scanner.nextLine().trim();

//            validation checks
            if (!options.getAddOptions().contains(response)) {
                System.out.println();
                System.out.println("Invalid option. Please try again.");
                continue;
            }
            if (response.equals("4")) {
                break;
            }

            int id = manager.lastAssignedID();
            Worker worker = createWorkerGeneralInfo(scanner, ++id);

//            determines which type of employee to be created based on user input
            switch (response) {
                case "1":
                    addFullTimeEmployee(manager, worker, scanner);
                    break;
                case "2":
                    addIntern(manager, worker, scanner);
                    break;
                case "3":
                    addContractor(manager, worker, scanner);
                    break;
            }
        }
    }

//    prompts for input and creates an instance of the Worker superclass
    private static Worker createWorkerGeneralInfo(Scanner scanner, int id) {
//        each of the static methods below runs the input through validation processes until a valid input is typed
        String name = Prompter.namePrompt(scanner);
        String department = Prompter.departmentPrompt(scanner);
        String role = Prompter.rolePrompt(scanner);
        double salary = Prompter.salaryPrompt(scanner);
        String startDate = Prompter.startDatePrompt(scanner);

        return new Worker(id, name, department, role, salary, startDate);
    }

//    each of the three methods below prompts for additional input, creates an instance of a class which extends Worker and adds it to the employee list
//    each subclass instance is initialized with the help of the superclass instance created earlier (by copying Worker's properties) so that its constructor doesn't take many parameters
    private static void addFullTimeEmployee(EmployeeManager manager, Worker worker, Scanner scanner) {
        double annualBonus = Prompter.annualBonusPrompt(scanner);
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(worker, annualBonus);
        manager.addEmployee(fullTimeEmployee);
    }

    private static void addIntern(EmployeeManager manager, Worker worker, Scanner scanner) {
        String endDate = Prompter.endDatePrompt(scanner, worker.getStartDate());

        System.out.print("University name: ");
        String uni = scanner.nextLine().trim();

        System.out.print("Major: ");
        String major = scanner.nextLine().trim();

        Intern intern = new Intern(worker, endDate, uni, major);
        manager.addEmployee(intern);
    }

    private static void addContractor(EmployeeManager manager, Worker worker, Scanner scanner) {
        String endDate = Prompter.endDatePrompt(scanner, worker.getStartDate());

        System.out.print("Employer name: ");
        String employerName = scanner.nextLine().trim();

        System.out.print("Project name: ");
        String projectName = scanner.nextLine().trim();

        Contractor contractor = new Contractor(worker, endDate, employerName, projectName);
        manager.addEmployee(contractor);
    }
}

