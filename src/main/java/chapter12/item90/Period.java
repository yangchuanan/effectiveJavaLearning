package chapter12.item90;

// Period class with serialization proxy

import java.util.*;
import java.io.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 22:12
 * @Description Immutable class that uses defensive copying
 * @Version 0.0.1
 */
public final class Period implements Serializable {
    private final Date start;
    private final Date end;

    /**
     * @param  start the beginning of the period
     * @param  end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end   = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(
                    start + " after " + end);
        }
    }

    public Date start () { return new Date(start.getTime()); }

    public Date end () { return new Date(end.getTime()); }

    @Override
    public String toString() { return start + " - " + end; }


    /** Serialization proxy for Period class */
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        // Any number will do (Item 87)
        private static final long serialVersionUID =
                234098243823485285L;
    }

    /** writeReplace method for the serialization proxy pattern */
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    /** readObject method for the serialization proxy pattern */
    private void readObject(ObjectInputStream stream)
            throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}