// has a fixed employment length by specifying End Date in the creation prompt (can still be fired)
package ExamOOP.EmployeeClasses;

public class Intern extends Worker {
    private String universityName;
    private String major;

    public Intern(Worker worker, String endDate, String universityName, String major) {
        super(worker.getId(), worker.getName(), worker.getDepartment(), worker.getRole(), worker.getSalary(), worker.getStartDate());
        super.setEndDate(endDate);
        super.setType("Intern");
        this.universityName = universityName;
        this.major = major;
    }

    public Intern(String[] fields) {
        super(fields);
        setUniversityName(fields[8]);
        setMajor(fields[9]);
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void printEmploymentDetails() {
        super.printEmploymentDetails();
        System.out.println("Type: " + getType());
        System.out.println("University: " + universityName);
        System.out.println("Major: " + major);
    }

    @Override
    public String toStringCSV() {
        return super.toStringCSV() + "," + universityName + "," + major;
    }
}
