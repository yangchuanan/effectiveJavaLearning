package chapter11.item83;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 21:57
 * @Description Initialization styles
 * @Version 0.0.1
 */
public class Initialization {

    /**
     * Normal initialization of an instance field4
     */
    private final FieldType field1 = computeFieldValue();

    /**
     * Lazy initialization of instance field4 - synchronized accessor
     */
    private FieldType field2;

    private synchronized FieldType getField2() {
        if (field2 == null) {
            field2 = computeFieldValue();
        }
        return field2;
    }

    /**
     * Lazy initialization holder class idiom for static fields
     */
    private static class FieldHolder {
        static final FieldType field = computeFieldValue();
    }

    private static FieldType getField() {
        return FieldHolder.field;
    }


    /**
     * Double-check idiom for lazy initialization of instance fields
     */
    private volatile FieldType field4;

    private FieldType getField4() {
        FieldType result = field4;
        // First check (no locking)
        if (result != null) {
            return result;
        }
        synchronized (this) {
            // Second check (with locking)
            if (field4 == null) {
                field4 = computeFieldValue();
            }
            return field4;
        }
    }


    /** Single-check idiom - can cause repeated initialization! */
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if (result == null) {
            field5 = result = computeFieldValue();
        }
        return result;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}
