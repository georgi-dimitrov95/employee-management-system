package ExamOOP.CsvUtil;

import ExamOOP.EmployeeClasses.Worker;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter {

    public static void writeEmployeesToCSV(String filePath, ArrayList<Worker> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Worker worker : employees) {
                writer.write(worker.toStringCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong during the writing process.");
        }
    }
}
