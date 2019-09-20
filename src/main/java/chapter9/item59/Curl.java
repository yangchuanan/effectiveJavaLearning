package chapter9.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 20:04
 * @Description Printing the contents of a URL with transferTo, added in Java 9
 * @Version 0.0.1
 */
public class Curl {
    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL(args[0]).openStream()) {
            in.transferTo(System.out);
        }
    }
}
