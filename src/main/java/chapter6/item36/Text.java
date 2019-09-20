package chapter6.item36;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 21:59
 * @Description EnumSet - a modern replacement for bit fields (Page 170)
 * 用EnumSet代替位域
 * @Version 0.0.1
 */
public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
                Objects.requireNonNull(styles));
    }

    // Sample use
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}