package ExamOOP.EmployeeClasses;

public class FullTimeEmployee extends Worker {
    private double annualBonus;

    public FullTimeEmployee(Worker worker, double annualBonus) {
//        is initialized with the help of a Worker instance so that its constructor doesn't take a lot of parameters
//        the same concept is applied in the other subclasses
        super(worker.getId(), worker.getName(), worker.getDepartment(), worker.getRole(), worker.getSalary(), worker.getStartDate());
        super.setEndDate("Unknown");
        super.setType("Full time employee");
        this.annualBonus = annualBonus;
    }

    public FullTimeEmployee(String[] fields) {
        super(fields);
        setAnnualBonus(Double.parseDouble(fields[8]));
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }

    @Override
    public void printEmploymentDetails() {
        super.printEmploymentDetails();
        System.out.println("Type: " + getType());
        System.out.printf("Annual bonus: %.2f\n", annualBonus);
    }

    @Override
    public String toStringCSV() {
        return super.toStringCSV() + "," + getDecimalFormat().format(annualBonus);
    }
}
