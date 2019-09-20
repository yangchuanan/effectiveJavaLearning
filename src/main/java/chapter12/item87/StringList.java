package chapter12.item87;
import java.io.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 22:08
 * @Description 使用自定义的序列化形式，不要使用java序列化
 * StringList with a reasonable custom serialized form
 * @Version 0.0.1
 */
public final class StringList implements Serializable {
    private transient int size   = 0;
    private transient Entry head = null;

    /** No longer Serializable! */
    private static class Entry {
        String data;
        Entry  next;
        Entry  previous;
    }

    /** Appends the specified string to the list */
    public final void add(String s) {  }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings
     * it contains) is emitted ({@code int}), followed by all of
     * its elements (each a {@code String}), in the proper
     * sequence.
     */
    private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // Read in all elements and insert them in list
        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }

    // Remainder omitted
}
