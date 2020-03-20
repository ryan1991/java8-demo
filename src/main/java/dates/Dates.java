package dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dates {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = now.format(dateTimeFormatter);
        LocalDateTime before = now.minusMinutes(2);
        String beforeFormat = before.format(dateTimeFormatter);
        System.out.println("format :" + format + " , before 2:" + beforeFormat);


    }



}
