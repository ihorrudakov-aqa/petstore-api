package org.petstore.automation.helpers;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static String getCurrentTimeFormatted() {
        OffsetDateTime now = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return now.format(formatter);
    }
}
