/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Hickey
 */


package ucf.assignments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    // Date format
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    // Formats the date
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    // Converts data into string
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    // Converts string into LocalDate object
    // Returns NULL if failed
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }
}