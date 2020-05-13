package trade.shoes.commons.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @Description
 * @Author bingfeng
 * @Date 2020/3/9 10:50
 */
public class LocalDateUtil {

    public static String DateFormatFull = "yyyy-MM-dd HH:mm:ss.S";
    public static String DateFormatStandard = "yyyy-MM-dd HH:mm:ss";
    public static String DateFormatShort = "MM-dd HH:mm";

    public static String DateFormatYearMonthDay = "yyyy-MM-dd";
    public static String DateFormatYearMonth = "yyyy-MM";

    private static final String[][] strArray = {{"MONDAY", "一"}, {"TUESDAY", "二"}, {"WEDNESDAY", "三"}, {"THURSDAY", "四"}, {"FRIDAY", "五"}, {"SATURDAY", "六"}, {"SUNDAY", "日"}};

    /**
     * Date转换为LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param time
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定时间的指定格式
     *
     * @param time
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的指定格式
     *
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     *
     * @param startTime
     * @param endTime
     * @param field     单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     *
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     *
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        number = -number;
        return time.minus(number, field);
    }

    /**
     * 描述 获取今天星期几
     *
     * @return
     */
    public static String getDayOfTheWeek() {

        LocalDate currentDate = LocalDate.now();
        String k = String.valueOf(currentDate.getDayOfWeek());
        //获取行数
        for (String[] strings : strArray) {
            if (k.equals(strings[0])) {
                k = strings[1];
                break;
            }
        }
        return "星期" + k;
    }

    /**
     * 描述 获取该日期是星期几
     *
     * @return
     */
    public static String getDayOfTheWeek(LocalDateTime dateTime) {

        String k = String.valueOf(dateTime.getDayOfWeek());
        //获取行数
        for (String[] strings : strArray) {
            if (k.equals(strings[0])) {
                k = strings[1];
                break;
            }
        }
        return "星期" + k;
    }
}
