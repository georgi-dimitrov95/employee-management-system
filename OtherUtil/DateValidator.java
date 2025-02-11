// validates dates
// used in the Prompter class methods

package ExamOOP.OtherUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateValidator {

//    checks if a date is in valid DD-MM-YYYY format
    public static boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate.parse(date.trim(), formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Please try again.");
            return false;
        }
    }

//    checks if the date is after 01-01-1900
    public static boolean isInValidDateRange(String date) {
        if (isValidDate(date.trim())) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(date.trim(), formatter);
            LocalDate minimalDate = LocalDate.of(1900, 1, 1);

            if (parsedDate.isAfter(minimalDate)) {
                return true;
            } else {
                System.out.println("Date is not in the valid range. The earliest possible date is " + minimalDate.format(formatter));
                return false;
            }
        }
        return false;
    }

//    compares if one date is after the other
    public static boolean endDateIsAfterStartDate(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(endDate.trim(), formatter).isAfter(LocalDate.parse(startDate.trim(), formatter));
    }
}
