package lang.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
/**
 * JDK 8 以前 时间日期API
 * 
 * 1.System.currentTimeMillis()
 * 
 * 2.java.util.Calendar;  java.util.Date;
 * 
 * 3.SimpleDateFormat
 * 
 * 4.Calender
 */
public class TestBefer8 {
    @Test
    public void testTime() {
        // 获取当前时间的毫秒数时间戳
        System.out.println("TestDateTime.testTime()");
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
    }

    @Test
    public void testDate() {
        // java.util.Date
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println(d1.getTime());// 毫秒数时间戳

        var d2 = new Date(1631504736660L);
        System.out.println(d2);

        // java.sql.Date 是 java.util.Date 的子类
        var d3 = new java.sql.Date(0L);
        System.out.println(d3);

        // java.sql.Date -> java.util.Date
        Date d4 = (Date) d3;
        System.out.println(d4);

        // java.util.Date -> java.sql.Date
        java.sql.Date d5 = new java.sql.Date(d4.getTime());
        System.out.println(d5);
    }

    /**
     * SimpleDateFormat对Date类的格式化和解析
     * 
     * 1.格式化: 日期 --> 字符串
     * 
     * 2.解析:格式化的逆过程: 字符串 --> 日期
     */
    @Test
    public void testFormat() {
        System.out.println("TestDateTime.testFormat()");

        // 格式化
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);

        // 指定格式
        final String parttern = "yyyy-MM-dd hh:mm:ss:SSS z";
        SimpleDateFormat sdf2 = new SimpleDateFormat(parttern);
        System.out.println(sdf2.format(date));

        try {
            // 解析
            String str = "2021/9/13 下午2:58";
            String s2 = "2002-10-09 08:31:12:234 CST";
            Date d1 = sdf.parse(str);
            System.out.println(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calender 抽象基类
     * 
     * 主要用于完成日期字段之间相互操作的功能
     * 
     */
    @Test
    public void testCalender() {
        // 1.调用静态方法获取实例
        Calendar cal = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        System.out.println(cal.getClass());// class java.util.GregorianCalendar
        System.out.println(cal.equals(instance2));//false
        
        //get
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
    }
}

