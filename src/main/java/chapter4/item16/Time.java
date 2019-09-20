package chapter4.item16;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:25
 * @Description Public class with exposed immutable fields - questionable   (Page 79)
 * @Version 0.0.1
 */
public final class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("Hour: " + hour);
        }
        if (minute < 0 || minute >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("Min: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }

    // Remainder omitted
}
