// includes methods that keep prompting for input until a valid one is typed
// the input is then assigned to various properties of the Worker superclass and its subclasses
// used in the creation and editing of employee instances

package ExamOOP.OtherUtil;

import java.util.Scanner;

public class Prompter {

//    prompts for a Start Date until a valid one is typed
    public static String startDatePrompt(Scanner scanner) {
        while (true) {
            System.out.print("Start of employment: ");
            String startDate = scanner.nextLine().trim();
            if (DateValidator.isInValidDateRange(startDate)) {
                return startDate;
            }
        }
    }

//    prompts for an End Date until a valid one is typed
    public static String endDatePrompt(Scanner scanner, String startDate) {
        while (true) {
            System.out.print("End of employment: ");
            String endDate = scanner.nextLine().trim();
            if (DateValidator.isInValidDateRange(endDate)) {
//                End Date should be after the Start Date
                if (DateValidator.endDateIsAfterStartDate(startDate, endDate)) {
                    return endDate;
                }
                System.out.println("The end date cannot be before the start date. Please try again.");
            }
        }
    }

//    generic method which keeps prompting for a string (name, department or role) until a valid input is typed
    private static String stringPrompt(Scanner scanner, String prompt, String regex, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
//            validation check
            if (input.matches(regex)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }

//    the three methods below call the stringPrompt method and only change the prompt string, the regex and the error message string
    public static String namePrompt(Scanner scanner) {
        String name = "Name: ";
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        String errorMessage = "Name must be in the following format: Jane Doe. Both names should be at least 2 letters long and contain only alphabetical characters.";
        return stringPrompt(scanner, name, regex, errorMessage);
    }

    public static String departmentPrompt(Scanner scanner) {
        String name = "Department: ";
        String regex = "^([A-Z][a-z]*(?: [A-Z][a-z]*)*)$";
        String errorMessage = "The department name should contain only alphabetical characters and every word should be capitalized. Example: Human Resources";
        return stringPrompt(scanner, name, regex, errorMessage);
    }

    public static String rolePrompt(Scanner scanner) {
        String name = "Role: ";
        String regex = "^([A-Z][a-z]*(?: [A-Z][a-z]*)*)$";
        String errorMessage = "The role name should contain only alphabetical characters and every word should be capitalized. Example: Java Developer";
        return stringPrompt(scanner, name, regex, errorMessage);
    }

//    generic method which keeps prompting for an int/double amount until a valid input is typed
    private static double numberPrompt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount <= 0) {
                    throw new NumberFormatException("Please provide a positive number/fractional");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Please provide a whole number or a fractional.");
            }
        }
    }

//    the two methods below call the numberPrompt method and only change the prompt string printed to the console
    public static double salaryPrompt(Scanner scanner) {
        return numberPrompt(scanner, "Salary: ");
    }

    public static double annualBonusPrompt(Scanner scanner) {
        return numberPrompt(scanner, "Annual bonus: ");
    }
}
