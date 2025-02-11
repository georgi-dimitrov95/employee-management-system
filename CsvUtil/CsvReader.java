package ExamOOP.CsvUtil;

import ExamOOP.EmployeeClasses.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    public static void readEmployeesFromCSV(String filePath, ArrayList<Worker> employees) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String type = fields[1];
                Worker worker = switch (type.toLowerCase()) {
                    case "full time employee" -> new FullTimeEmployee(fields);
                    case "intern" -> new Intern(fields);
                    case "contractor" -> new Contractor(fields);
                    default -> null;
                };
                employees.add(worker);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong during the reading process.");
        }
    }
}
