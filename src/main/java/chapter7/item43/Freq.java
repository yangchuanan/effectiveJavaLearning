package chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/5 21:51
 * @Description 使用lambda 函数引用实现频率统计
 * Frequency table implemented with map.merge, using lambda and method reference (Page 197)
 * @Version 0.0.1
 */
public class Freq {
    public static void main(String[] args) {
        String[] arg = new String[4];
        arg[0]="2";
        arg[1]="hello";
        arg[2]="2";
        arg[3]="3";
        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : arg) {
            // Lambda
            frequencyTable.merge(s, 1, (count, incr) -> count + incr);
        }
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for (String s : arg) {
            // Method reference
            frequencyTable.merge(s, 1, Integer::sum);
        }
        System.out.println(frequencyTable);

    }
}
