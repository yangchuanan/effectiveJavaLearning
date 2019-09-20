package chapter6.item34;

import static chapter6.item34.PayrollDay.PayType.WEEKDAY;
import static chapter6.item34.PayrollDay.PayType.WEEKEND;
import static chapter6.item34.PayrollDay.PayType.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:41
 * @Description The strategy enum pattern (Page 166)
 * @Version 0.0.1
 */
enum PayrollDay {
    /**
     * 日期
     */
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY),
    THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/9/1 21:43
     * @Description The strategy enum type
     * @Version 0.0.1
     */
    enum PayType {
        /**
         * 工作日
         */
        WEEKDAY {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                        (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

    public static void main(String[] args) {
        for (PayrollDay day : values()) {
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
        }
    }
}
