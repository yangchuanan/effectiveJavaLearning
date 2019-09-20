package chapter3.item13;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 18:49
 * @Description Adding a clone method to PhoneNumber (page 59)
 * @Version 0.0.1
 */
@Data
public final class PhoneNumber implements Cloneable {
    //    private final short areaCode, prefix, lineNum;
    private short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // Clone method for class with no references to mutable state (Page 59)
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            // Can't happen
            throw new AssertionError();
        }
    }

    public void SetArea(short areaCode) {
        this.areaCode = areaCode;
    }

    public static void main(String[] args) {
        PhoneNumber pn = new PhoneNumber(707, 867, 5309);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(pn, "Jenny");
        PhoneNumber clone = pn.clone();
        System.out.println(m.get(pn.clone()));
        System.out.println(pn.equals(pn.clone()));
        // clone为深复制
        pn.setAreaCode((short)236);
        System.out.println(pn);
        System.out.println(clone);
    }
}
