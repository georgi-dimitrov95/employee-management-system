package ExamOOP.Menu;

public class Menu {

//    greets the user upon starting the program
    public static void greetingMenu() {
        System.out.println();
        String welcome = "Welcome to the Employee Management Application!";
        System.out.println("=".repeat(welcome.length()));
        System.out.println(welcome);
        System.out.println("=".repeat(welcome.length()));
    }

    public static void inputExamples() {
        System.out.println();
        System.out.println("Examples for some of the required input:");
        System.out.println("Option: 3 ---> always input a number when choosing among the options from the various menus");
        System.out.println("Name: Jane Doe ---> should have two names, each consisting only of alphabetical characters and equal or more than 2 letters");
        System.out.println("Department: Human Resources ---> can consist of one or more words, each capitalized");
        System.out.println("Role: Java Developer ---> same as Department");
        System.out.println("Salary/Annual bonus: 1000/1000.55 ---> a positive integer/float");
        System.out.println("Start date/End date: 15-12-2005 ---> DD-MM-YYYY format");
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Add an employee");
        System.out.println("2. Edit employee info");
        System.out.println("3. Fire an employee");
        System.out.println("4. List employees");
        System.out.println("5. Search");
        System.out.println("6. Exit");
    }

    public static void addEmployeeMenu() {
        System.out.println();
        System.out.println("Specify what type of employee would you like to add. Please choose an option.");
        System.out.println("1. Full time employee");
        System.out.println("2. Intern");
        System.out.println("3. Contractor");
        System.out.println("4. Back to the main menu");
    }

    public static void editMainInfoMenu() {
        System.out.println();
        System.out.println("Which field would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Department");
        System.out.println("3. Role");
        System.out.println("4. Salary");
    }

    public static void editFullTimeEmployeeMenu() {
        editMainInfoMenu();
        System.out.println("5. Annual bonus");
        System.out.println("6. Back to the main menu");
    }

    public static void editInternMenu() {
        editMainInfoMenu();
        System.out.println("5. University");
        System.out.println("6. Major");
        System.out.println("7. Back to the main menu");
    }

    public static void editContractorMenu() {
        editMainInfoMenu();
        System.out.println("5. Employer name");
        System.out.println("6. Project name");
        System.out.println("7. Back to the main menu");
    }

    public static void listMenu() {
        System.out.println();
        System.out.println("Which employees would you like to see? Please choose an option.");
        System.out.println("1. All employees");
        System.out.println("2. Full time employees");
        System.out.println("3. Interns");
        System.out.println("4. Contractors");
        System.out.println("5. Past employees");
        System.out.println("6. Back to the main menu");
    }

    public static void searchMenu() {
        System.out.println();
        System.out.println("By what criteria would you like to make a search? Please choose an option.");
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Department");
        System.out.println("4. Role");
        System.out.println("5. Back to the main menu");
    }
}

