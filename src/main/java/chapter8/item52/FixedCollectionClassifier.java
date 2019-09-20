package chapter8.item52;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 19:18
 * @Description Repaired  static classifier method. (Page 240)
 * @Version 0.0.1
 */
public class FixedCollectionClassifier {
    public static String classify(Collection<?> c) {
        return c instanceof Set ? "Set" :
                c instanceof List ? "List" : "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
