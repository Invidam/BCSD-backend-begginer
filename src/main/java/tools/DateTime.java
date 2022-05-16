package tools;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    LocalDateTime dateTime;

    public DateTime() {
        dateTime = LocalDateTime.now();
    }
    public DateTime(String datetimeStr) {
        dateTime = LocalDateTime.parse(datetimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }
    public String stringify() {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public static void main(String[] args) {

    }
}
