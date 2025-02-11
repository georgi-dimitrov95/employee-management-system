// has a fixed employment length by specifying End Date in the creation prompt (can still be fired)
package ExamOOP.EmployeeClasses;

public class Contractor extends Worker {
    private String employerName;
//    the project on which the contractor is partnering with the company
    private String projectName;

    public Contractor(Worker worker, String endDate, String employerName, String projectName) {
        super(worker.getId(), worker.getName(), worker.getDepartment(), worker.getRole(), worker.getSalary(), worker.getStartDate());
        super.setEndDate(endDate);
        super.setType("Contractor");
        this.employerName = employerName;
        this.projectName = projectName;
    }

    public Contractor(String[] fields) {
        super(fields);
        setEmployerName(fields[8]);
        setProjectName(fields[9]);
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public void printEmploymentDetails() {
        super.printEmploymentDetails();
        System.out.println("Type: " + getType());
        System.out.println("Employer: " + employerName);
        System.out.println("Contributing to project(name): " + projectName);
    }

    @Override
    public String toStringCSV() {
        return super.toStringCSV() + "," + employerName + "," + projectName;
    }
}
