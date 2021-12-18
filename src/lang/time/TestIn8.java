package lang.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;

/**
 * JDK 8 中的时间日期API
 * 
 * 1.LocalDate
 * 
 * 2.LocalTime
 * 
 * 3.LocalDateTime
 * 
 * 4.Instant 机器时间
 * 
 * 5.DateTimeFormater
 */
public class TestIn8 {
    @Test
    public void testDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    @Test
    public void testTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    @Test
    public void testLocalDateTime() {
        // now 获取当前的日期和时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // of 获取指定的日期时间 没有偏移量
        LocalDateTime of = LocalDateTime.of(2002, 10, 9, 16, 34, 35);
        System.out.println(of);

        // getXxx
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getChronology());
    }

    @Test
    public void testInstant() {
        // now() 获取本初子午线对应的标准时间
        Instant now = Instant.now();
        System.out.println(now);// 慢八个小时

        // 添加时间偏移量
        OffsetDateTime offSet = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offSet);

        // 1970(UTC)->现在 经过的毫秒数
        long epochMilli = now.toEpochMilli();
        System.out.println(epochMilli);// 1631521135573

        // 毫秒数->instant
        Instant ofEpochMilli = Instant.ofEpochMilli(1631521135573L);
        System.out.println(ofEpochMilli);
    }

    @Test
    public void testDateTimeFormater() {
        LocalDateTime now = LocalDateTime.now();

        // 格式化1
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String format = formatter.format(now);
        System.out.println(format); // 2021-09-13T16:56:14.4738222

        // 解析
        TemporalAccessor parse = formatter.parse("2021-09-13T16:56:14.4738222");
        System.out.println(parse);

        // 格式化2: 本地格式化
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String format2 = formatter2.format(now);
        System.out.println(format2);

        // 格式化3: 自定义格式化
        final String pattern="GG yyyy年MM月dd日 EE a hh时mm分ss秒";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern(pattern);
        String format3 = formatter3.format(LocalDateTime.now());
        System.out.println(format3);
    }
}
