package chapter4.item20;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 19:37
 * @Description Skeletal implementation class (Pages 102-3)
 * @Version 0.0.1
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    // Entries in a modifiable map must override this method
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Implements the general contract of Map.Entry.equals
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(), getKey())
                && Objects.equals(e.getValue(), getValue());
    }

    // Implements the general contract of Map.Entry.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}


