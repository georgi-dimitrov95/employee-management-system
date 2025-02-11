// superclass which is extended by FullTimeEmployee, Intern, Contractor

package ExamOOP.EmployeeClasses;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Worker implements Employed {
    private DecimalFormat decimalFormat = createDecimalFormat();
    private int id;
    private String type;
    private String name;
    private String department;
    private String role;
    private double salary;
    private String startDate;
    private String endDate;

    public Worker(int id, String name, String department, String role, double salary, String startDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.startDate = startDate;
    }

//    used by the subclasses constructors when reading from a CSV file
    public Worker(String[] fields) {
        setId(Integer.parseInt(fields[0]));
        setType(fields[1]);
        setName(fields[2]);
        setDepartment(fields[3]);
        setRole(fields[4]);
        setSalary(Double.parseDouble(fields[5]));
        setStartDate(fields[6]);
        setEndDate(fields[7]);
    }

    public Worker() {

    }

//    sets the format and delimiter of the String representation of float numbers (so that they don't break csv reading logic)
    private static DecimalFormat createDecimalFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        return new DecimalFormat("#.##", symbols);
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void printEmploymentDetails() {
        System.out.println();
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Role: " + role);
        System.out.printf("Salary: %.2f\n", salary);
        System.out.println("Start of employment: " + startDate);
        System.out.println("End of employment: " + endDate);
    }

//    formats all the fields, so they can be written as a single line in a CSV file
    public String toStringCSV() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s", id, type, name, department, role, decimalFormat.format(salary), startDate, endDate);
    }
}
