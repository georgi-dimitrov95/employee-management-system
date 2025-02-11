package ExamOOP.Menu;

import java.util.ArrayList;
import java.util.Collections;

public class MenuOptions {
    private ArrayList<String> mainOptions;
    private ArrayList<String> addEmployeeOptions;
    private ArrayList<String> editFullTimeEmployeeOptions;
    private ArrayList<String> editInternOptions;
    private ArrayList<String> editContractorOptions;
    private ArrayList<String> listOptions;
    private ArrayList<String> searchOptions;

    public MenuOptions() {
        mainOptions = new ArrayList<>();
        Collections.addAll(mainOptions, "1", "2", "3", "4", "5", "6");

        addEmployeeOptions = new ArrayList<>();
        Collections.addAll(addEmployeeOptions, "1", "2", "3", "4");

        editFullTimeEmployeeOptions = new ArrayList<>();
        Collections.addAll(editFullTimeEmployeeOptions, "1", "2", "3", "4", "5", "6");

        editInternOptions = new ArrayList<>();
        Collections.addAll(editInternOptions, "1", "2", "3", "4", "5", "6", "7");

        editContractorOptions = new ArrayList<>();
        Collections.addAll(editContractorOptions, "1", "2", "3", "4", "5", "6", "7");

        listOptions = new ArrayList<>();
        Collections.addAll(listOptions, "1", "2", "3", "4", "5", "6");

        searchOptions = new ArrayList<>();
        Collections.addAll(searchOptions, "1", "2", "3", "4", "5");
    }

    public ArrayList<String> getMainOptions() {
        return mainOptions;
    }

    public ArrayList<String> getAddOptions() {
        return addEmployeeOptions;
    }

    public ArrayList<String> getEditFullTimeEmployeeOptions() {
        return editFullTimeEmployeeOptions;
    }

    public ArrayList<String> getEditInternOptions() {
        return editInternOptions;
    }

    public ArrayList<String> getEditContractorOptions() {
        return editContractorOptions;
    }

    public ArrayList<String> getListOptions() {
        return listOptions;
    }

    public ArrayList<String> getSearchOptions() {
        return searchOptions;
    }
}
