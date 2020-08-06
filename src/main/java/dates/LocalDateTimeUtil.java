package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018-12-28 17:55.
 */
public final class LocalDateTimeUtil {


    /**
     * {@code java.util.Date} to {@code java.time.LocalDateTime}
     *
     * @param date java.util.Date
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * {@code java.time.LocalDateTime} to {@code java.util.Date}
     *
     * @param localDateTime java.time.LocalDateTime
     * @return java.util.Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * {@code java.time.LocalDate} to {@code java.util.Date}
     *
     * @param localDate java.time.LocalDate
     * @return java.util.Date
     */
    public static Date toDate(LocalDate localDate) {
        return toDate(localDate.atTime(0, 0));
    }

    /**
     * {@code java.util.Date} to {@code java.time.LocalDateTime}
     *
     * @param date java.util.Date
     * @return java.time.LocalDateTime
     */
    public static LocalDate toLocalDate(Date date) {
        return toLocalDateTime(date).toLocalDate();
    }

    /**
     * 从1970年到现在的秒数
     *
     * @param localDateTime java.time.LocalDateTime
     * @return 秒数
     */
    public static long toEpochSecond(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    /**
     * 从1970年到现在的毫秒数
     *
     * @param localDateTime java.time.LocalDateTime
     * @return 毫秒数
     */
    public static long toEpochMileSecond(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static List<String> getDays(LocalDate startDate, LocalDate endDate, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        List<String> days = new ArrayList<>();
        while (!startDate.isAfter(endDate)){
            String day = formatter.format(startDate);
            days.add(day);
            startDate = startDate.plusDays(1);
        }
        return days;
    }

    public static String preDay(){
        return LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
