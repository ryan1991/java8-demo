package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Dates {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = now.format(dateTimeFormatter);
        LocalDateTime before = now.minusMinutes(2);
        String beforeFormat = before.format(dateTimeFormatter);
        System.out.println("format :" + format + " , before 2:" + beforeFormat);


        List<String> days = LocalDateTimeUtil.getDays(LocalDate.now().minusDays(8), LocalDate.now().minusDays(1), "yyyy-MM-dd");
        System.out.println(days);

        ZonedDateTime timestamp = ZonedDateTime.now();
        System.out.println("t1:" + timestamp);
        System.out.println("t2:" + System.currentTimeMillis());


    }



}
