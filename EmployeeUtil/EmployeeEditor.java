// provides static methods which directly edit employee's properties
// used in EditOperations class

package ExamOOP.EmployeeUtil;

import ExamOOP.EmployeeClasses.*;
import ExamOOP.OtherUtil.Prompter;
import java.util.Scanner;

public class EmployeeEditor {

//    edits a single property from the main ones of an employee depending on user input
//    this method is also present in the remaining ones in this class and it is called if the user wants to edit one of the main properties (name, department, role, salary) which are defined in the superclass Worker
    private static void editMainInfo(Worker worker, Scanner scanner, String response) {
        switch (response) {
            case "1":
                String name = Prompter.namePrompt(scanner);
                worker.setName(name);
                break;
            case "2":
                String department = Prompter.departmentPrompt(scanner);
                worker.setDepartment(department);
                break;
            case "3":
                String role = Prompter.rolePrompt(scanner);
                worker.setRole(role);
                break;
            case "4":
                double salary = Prompter.salaryPrompt(scanner);
                worker.setSalary(salary);
                break;
        }
    }

//    each of the three methods below prompts for user input and edits the corresponding property
    public static void editFullTimeEmployee(Worker worker, Scanner scanner, String response) {
        if (response.equals("5")) {
            double annualBonus = Prompter.annualBonusPrompt(scanner);
            ((FullTimeEmployee) worker).setAnnualBonus(annualBonus);
        } else {
//            if the user has chosen to edit a property from the superclass rather than a property from the subclass
            editMainInfo(worker, scanner, response);
        }
    }

    public static void editIntern(Worker worker, Scanner scanner, String response) {
        switch (response) {
            case "5":
                System.out.print("University: ");
                String uni = scanner.nextLine().trim();
                ((Intern) worker).setUniversityName(uni);
                break;
            case "6":
                System.out.print("Major: ");
                String major = scanner.nextLine().trim();
                ((Intern) worker).setMajor(major);
                break;
            default:
                editMainInfo(worker, scanner, response);
        }
    }

    public static void editContractor(Worker worker, Scanner scanner, String response) {
        switch (response) {
            case "5":
                System.out.print("Employer name: ");
                String employer = scanner.nextLine().trim();
                ((Contractor) worker).setEmployerName(employer);
                break;
            case "6":
                System.out.print("Project name: ");
                String project = scanner.nextLine().trim();
                ((Contractor) worker).setProjectName(project);
                break;
            default:
                editMainInfo(worker, scanner, response);
        }
    }
}
