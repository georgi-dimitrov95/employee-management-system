package ExamOOP.EmployeeUtil;

import ExamOOP.EmployeeClasses.*;
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Worker> activeEmployees;
    private ArrayList<Worker> pastEmployees;

    public EmployeeManager() {
        this.activeEmployees = new ArrayList<>();
        this.pastEmployees = new ArrayList<>();
    }

    public ArrayList<Worker> getActiveEmployees() {
        return activeEmployees;
    }

    public ArrayList<Worker> getPastEmployees() {
        return pastEmployees;
    }

    public void addEmployee(Worker worker) {
        activeEmployees.add(worker);
    }

    public void fireEmployee(Worker worker) {
        pastEmployees.add(worker);
        activeEmployees.remove(worker);
    }

//    returns the last id assigned to an element from either of the lists (the last added employee can be fired thus the pastEmployees list is checked as well)
    public int lastAssignedID() {
        int activeEmployeesLastID = 0;
        int pastEmployeesLastID = 0;

        if (!getActiveEmployees().isEmpty()) {
            activeEmployeesLastID = getActiveEmployees().getLast().getId();
        }

        if (!getPastEmployees().isEmpty()) {
            pastEmployeesLastID = getPastEmployees().getLast().getId();
        }

        if (activeEmployeesLastID != 0 || pastEmployeesLastID != 0) {
            return Math.max(activeEmployeesLastID, pastEmployeesLastID);
        }
        return 0;
    }
}
