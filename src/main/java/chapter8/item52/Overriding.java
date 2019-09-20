package chapter8.item52;

import java.util.List;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 19:16
 * @Description Classification using method overrriding (Page 239)
 * @Version 0.0.1
 */
public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne());

        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}
