package chapter12.item89.enumsingleton;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 22:11
 * @Description Enum singleton - the preferred approach
 * @Version 0.0.1
 */
public enum Elvis {
    /** 枚举单例 */
    INSTANCE;
    private String[] favoriteSongs =
        { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}